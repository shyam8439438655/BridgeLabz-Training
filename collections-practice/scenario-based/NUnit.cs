using NUnit.Framework;
using System;

namespace BankAccountTests
{
    [TestFixture]   // Required test attribute for class
    public class UnitTest
    {
        [Test]   
        public void Test_Deposit_ValidAmount()
        {
            Program account = new Program(100m);
            account.Deposit(50m);

            // Only ONE assert
            Assert.AreEqual(150m, account.Balance);
        }

        [Test]
        [ExpectedException(typeof(Exception), ExpectedMessage = "Deposit amount cannot be negative")]
        public void Test_Deposit_NegativeAmount()
        {
            Program account = new Program(100m);
            account.Deposit(-20m);

        }

        [Test]
        public void Test_Withdraw_ValidAmount()
        {
            Program account = new Program(200m);
            account.Withdraw(50m);

            // Only ONE assert
            Assert.AreEqual(150m, account.Balance);
        }

        [Test]
        [ExpectedException(typeof(Exception), ExpectedMessage = "Insufficient funds.")]
        public void Test_Withdraw_InsufficientFunds()
        {
            Program account = new Program(100m);
            account.Withdraw(150m);

        }
    }
}
