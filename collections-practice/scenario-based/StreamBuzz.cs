using System;
using System.Collections.Generic;
using System.Linq;

public class CreatorStats
{
    public string CreatorName { get; set; }
    public double[] WeeklyLikes { get; set; }

    public static List<CreatorStats> EngagementBoard = new List<CreatorStats>();
}

public class StreamBuzz
{
    public void RegisterCreator(CreatorStats record)
    {
        CreatorStats.EngagementBoard.Add(record);
        Console.WriteLine("Creator registered successfully");
    }

    public Dictionary<string, int> GetTopPostCounts(List<CreatorStats> records, double likeThreshold)
    {
        Dictionary<string, int> result = new Dictionary<string, int>();

        foreach (var creator in records)
        {
            int count = creator.WeeklyLikes.Count(likes => likes >= likeThreshold);
            if (count > 0)
            {
                result[creator.CreatorName] = count;
            }
        }

        return result;
    }

    public double CalculateAverageLikes()
    {
        if (CreatorStats.EngagementBoard.Count == 0)
            return 0;

        double totalLikes = 0;
        int totalWeeks = 0;

        foreach (var creator in CreatorStats.EngagementBoard)
        {
            totalLikes += creator.WeeklyLikes.Sum();
            totalWeeks += creator.WeeklyLikes.Length;
        }

        return totalLikes / totalWeeks;
    }

    public static void Main(string[] args)
    {
        Program program = new Program();
        int choice;

        do
        {
            Console.WriteLine("1. Register Creator");
            Console.WriteLine("2. Show Top Posts");
            Console.WriteLine("3. Calculate Average Likes");
            Console.WriteLine("4. Exit");
            Console.WriteLine("Enter your choice:");
            choice = Convert.ToInt32(Console.ReadLine());

            switch (choice)
            {
                case 1:
                    Console.WriteLine("Enter Creator Name:");
                    string name = Console.ReadLine();

                    double[] weeklyLikes = new double[4];
                    Console.WriteLine("Enter weekly likes (Week 1 to 4):");
                    for (int i = 0; i < 4; i++)
                    {
                        weeklyLikes[i] = Convert.ToDouble(Console.ReadLine());
                    }

                    CreatorStats creator = new CreatorStats
                    {
                        CreatorName = name,
                        WeeklyLikes = weeklyLikes
                    };

                    program.RegisterCreator(creator);
                    break;

                case 2:
                    Console.WriteLine("Enter like threshold:");
                    double threshold = Convert.ToDouble(Console.ReadLine());

                    var topPosts = program.GetTopPostCounts(CreatorStats.EngagementBoard, threshold);

                    if (topPosts.Count == 0)
                    {
                        Console.WriteLine("No top-performing posts this week");
                    }
                    else
                    {
                        foreach (var kvp in topPosts)
                        {
                            Console.WriteLine($"{kvp.Key} - {kvp.Value}");
                        }
                    }
                    break;

                case 3:
                    double avg = program.CalculateAverageLikes();
                    Console.WriteLine("Overall average weekly likes: " + avg);
                    break;

                case 4:
                    Console.WriteLine("Logging off - Keep Creating with StreamBuzz!");
                    break;

                default:
                    Console.WriteLine("Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 4);
    }
}