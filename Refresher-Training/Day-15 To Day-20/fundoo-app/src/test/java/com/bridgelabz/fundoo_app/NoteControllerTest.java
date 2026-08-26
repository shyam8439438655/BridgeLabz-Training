package com.bridgelabz.fundoo_app;

import com.bridgelabz.fundoo_app.dto.LoginRequest;
import com.bridgelabz.fundoo_app.dto.NoteRequest;
import com.bridgelabz.fundoo_app.dto.RegisterRequest;
import com.bridgelabz.fundoo_app.entity.Note;
import com.bridgelabz.fundoo_app.entity.NoteLabel;
import com.bridgelabz.fundoo_app.entity.User;
import com.bridgelabz.fundoo_app.repository.NoteLabelRepository;
import com.bridgelabz.fundoo_app.repository.NoteRepository;
import com.bridgelabz.fundoo_app.repository.UserRepository;
import com.bridgelabz.fundoo_app.repository.CollaboratorRepository;
import com.bridgelabz.fundoo_app.security.JwtService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class NoteControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private NoteLabelRepository noteLabelRepository;

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private String user1Token;
    private User user1;

    private String user2Token;
    private User user2;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
        collaboratorRepository.deleteAll();
        noteRepository.deleteAll();
        noteLabelRepository.deleteAll();
        userRepository.deleteAll();

        // Create User 1
        User u1 = User.builder()
                .firstName("Shyam")
                .lastName("Kumar")
                .email("shyam@example.com")
                .passwordHash(passwordEncoder.encode("password123"))
                .build();
        user1 = userRepository.save(u1);
        user1Token = "Bearer " + jwtService.generateToken(user1.getUserId(), user1.getEmail());

        // Create User 2 (for ownership testing)
        User u2 = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .passwordHash(passwordEncoder.encode("password123"))
                .build();
        user2 = userRepository.save(u2);
        user2Token = "Bearer " + jwtService.generateToken(user2.getUserId(), user2.getEmail());
    }

    @Test
    void testUserRegistrationAndLoginFlow() throws Exception {
        // Register new user
        RegisterRequest regReq = new RegisterRequest("Alice", "Smith", "alice@example.com", "securePass");
        mockMvc.perform(post("/user/userSignUp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(regReq)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.token", notNullValue()));

        // Try registering same email (duplicate check)
        mockMvc.perform(post("/user/userSignUp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(regReq)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", containsString("Email already registered")));

        // Valid Login
        LoginRequest loginReq = new LoginRequest("alice@example.com", "securePass");
        mockMvc.perform(post("/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginReq)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token", notNullValue()));

        // Invalid Login
        LoginRequest badLogin = new LoginRequest("alice@example.com", "wrongPass");
        mockMvc.perform(post("/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(badLogin)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", containsString("Invalid email or password")));

        // Password Reset Request
        mockMvc.perform(post("/user/reset")
                        .param("email", "alice@example.com"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Password reset link sent successfully")));
    }

    @Test
    void testNoteCrudAndOwnershipConstraints() throws Exception {
        // Add Note
        NoteRequest noteReq = new NoteRequest("My Task", "Complete the refresher training", "#FFFFFF", "TEXT", null, null);
        String addResponse = mockMvc.perform(post("/notes/addNotes")
                        .header("Authorization", user1Token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(noteReq)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title", is("My Task")))
                .andExpect(jsonPath("$.noteId", notNullValue()))
                .andReturn().getResponse().getContentAsString();

        Note createdNote = objectMapper.readValue(addResponse, Note.class);
        Integer noteId = createdNote.getNoteId();

        // Get Details
        mockMvc.perform(get("/notes/getNotesDetail/" + noteId)
                        .header("Authorization", user1Token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("My Task")));

        // Verify Ownership: User 2 tries to fetch User 1's note -> 404
        mockMvc.perform(get("/notes/getNotesDetail/" + noteId)
                        .header("Authorization", user2Token))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error", is("Note not found")));

        // Update Note
        NoteRequest updateReq = new NoteRequest("My Task Updated", "New description", "#000000", "TEXT", null, null);
        mockMvc.perform(post("/notes/updateNotes")
                        .header("Authorization", user1Token)
                        .param("noteId", noteId.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateReq)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("My Task Updated")));

        // List active notes
        mockMvc.perform(get("/notes/getNotesList")
                        .header("Authorization", user1Token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void testStateTransitionsPinArchiveTrash() throws Exception {
        Note note = Note.builder()
                .title("State Test")
                .description("Testing states")
                .owner(user1)
                .build();
        note = noteRepository.save(note);
        Integer noteId = note.getNoteId();

        // Pin note
        mockMvc.perform(post("/notes/pinUnpinNotes")
                        .header("Authorization", user1Token)
                        .param("noteId", noteId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pined", is(true)));

        // Archive note (should unpin automatically)
        mockMvc.perform(post("/notes/archiveNotes")
                        .header("Authorization", user1Token)
                        .param("noteId", noteId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.archived", is(true)))
                .andExpect(jsonPath("$.pined", is(false)));

        // Trash note
        mockMvc.perform(post("/notes/trashNotes")
                        .header("Authorization", user1Token)
                        .param("noteId", noteId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.deleted", is(true)));

        // Try pinning trashed note -> Expect failure (400)
        mockMvc.perform(post("/notes/pinUnpinNotes")
                        .header("Authorization", user1Token)
                        .param("noteId", noteId.toString()))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", containsString("Cannot pin a trashed note")));

        // Hard Deletion
        mockMvc.perform(post("/notes/deleteForeverNotes")
                        .header("Authorization", user1Token)
                        .param("noteId", noteId.toString()))
                .andExpect(status().isOk());

        // Note should be gone
        assertTrue(noteRepository.findById(noteId).isEmpty());
    }

    @Test
    void testLabelManagementAndUniqueness() throws Exception {
        // Create Label
        String labelResponse = mockMvc.perform(post("/labels/create")
                        .header("Authorization", user1Token)
                        .param("labelName", "work"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.label", is("work")))
                .andReturn().getResponse().getContentAsString();

        NoteLabel createdLabel = objectMapper.readValue(labelResponse, NoteLabel.class);
        Integer labelId = createdLabel.getId();

        // Uniqueness check: duplicate label for same user -> 400
        mockMvc.perform(post("/labels/create")
                        .header("Authorization", user1Token)
                        .param("labelName", "work"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", containsString("already exists")));

        // Update Label
        mockMvc.perform(post("/labels/update")
                        .header("Authorization", user1Token)
                        .param("id", labelId.toString())
                        .param("newLabelName", "work-renamed"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.label", is("work-renamed")));

        // Add Label to Note
        Note note = Note.builder()
                .title("Note for Label")
                .description("My desc")
                .owner(user1)
                .build();
        note = noteRepository.save(note);
        Integer noteId = note.getNoteId();

        mockMvc.perform(post("/labels/addLabelToNote")
                        .header("Authorization", user1Token)
                        .param("noteId", noteId.toString())
                        .param("labelId", labelId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.labels", hasSize(1)));

        // Remove Label from Note
        mockMvc.perform(post("/labels/removeLabelFromNote")
                        .header("Authorization", user1Token)
                        .param("noteId", noteId.toString())
                        .param("labelId", labelId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.labels", empty()));
    }

    @Test
    void testSearchAndJpaSpecifications() throws Exception {
        Note note1 = Note.builder()
                .title("Meeting Minutes")
                .description("Discuss features UC3-UC10")
                .owner(user1)
                .isPined(true)
                .build();
        noteRepository.save(note1);

        Note note2 = Note.builder()
                .title("Shopping List")
                .description("Milk, Eggs, Bread")
                .owner(user1)
                .isArchived(true)
                .build();
        noteRepository.save(note2);

        // Search by title text
        mockMvc.perform(get("/notes/search")
                        .header("Authorization", user1Token)
                        .param("titleText", "meeting"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is("Meeting Minutes")));

        // Search by state (pinned)
        mockMvc.perform(get("/notes/search")
                        .header("Authorization", user1Token)
                        .param("state", "pinned"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is("Meeting Minutes")));

        // Search by state (archived)
        mockMvc.perform(get("/notes/search")
                        .header("Authorization", user1Token)
                        .param("state", "archived"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is("Shopping List")));
    }

    @Test
    void testRemindersJmsAndCollaboratorsRabbitMq() throws Exception {
        Note note = Note.builder()
                .title("Messaging Test")
                .description("JMS and RabbitMQ")
                .owner(user1)
                .build();
        note = noteRepository.save(note);
        Integer noteId = note.getNoteId();

        // Add Reminder (should trigger JMS listener)
        mockMvc.perform(post("/notes/addUpdateReminderNotes")
                        .header("Authorization", user1Token)
                        .param("noteId", noteId.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(Collections.singletonList("2026-08-25T10:00:00"))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reminders", hasSize(1)));

        // Remove Reminder
        mockMvc.perform(post("/notes/removeReminderNotes")
                        .header("Authorization", user1Token)
                        .param("noteId", noteId.toString())
                        .param("reminder", "2026-08-25T10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reminders", empty()));

        // Share Note with user2 (should trigger RabbitMQ listener)
        mockMvc.perform(post("/notes/" + noteId + "/share")
                        .header("Authorization", user1Token)
                        .param("collaboratorEmail", "john@example.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.collaborators", hasSize(1)));
    }
}
