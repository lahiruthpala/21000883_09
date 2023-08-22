object Q0904 extends App{
    class Account(initialBalance: Double) {
        private var balance: Double = initialBalance

        def getBalance: Double = balance

        def deposit(amount: Double): Unit = {
            if (amount > 0) {
                balance += amount
                println(s"Deposited $amount. New balance: $balance")
            } else {
                println("Invalid deposit amount.")
            }
        }

        def withdraw(amount: Double): Unit = {
            if (amount > 0 && amount <= balance) {
                balance -= amount
                println(s"Withdrew $amount. New balance: $balance")
            } else {
                println("Invalid withdrawal amount or insufficient balance.")
            }
        }

        def transfer(amount: Double, targetAccount: Account): Unit = {
            if (amount > 0 && amount <= balance) {
                balance -= amount
                targetAccount.deposit(amount)
                println(s"Transferred $amount to target account. New balance: $balance")
            } else {
                println("Invalid transfer amount or insufficient balance.")
            }
        }

        def applyInterest(): Unit = {
            val interestRate = if (balance > 0) 0.05 else 0.1
            val interest = balance * interestRate
            balance += interest
            println(s"Applied interest. New balance: $balance")
        }

        override def toString: String = s"Balance: $balance"
    }

    object Bank {
        private var accounts: List[Account] = List()

        def addAccount(account: Account): Unit = {
            accounts = account :: accounts
            println("Account added to the bank.")
        }

        def negativeBalanceAccounts: List[Account] = accounts.filter(_.getBalance < 0)

        def totalBalance: Double = accounts.map(_.getBalance).sum

        def applyInterestToAll(): Unit = {
            accounts.foreach(_.applyInterest())
            println("Interest applied to all accounts.")
        }
    }

    object Main extends App {
        val account1 = new Account(1000.0)
        val account2 = new Account(-500.0)
        val account3 = new Account(2000.0)

        Bank.addAccount(account1)
        Bank.addAccount(account2)
        Bank.addAccount(account3)

        println(s"Negative balance accounts: ${Bank.negativeBalanceAccounts}")
        println(s"Total bank balance: ${Bank.totalBalance}")

        Bank.applyInterestToAll()

        println(s"Final balances after applying interest:")
        Bank.negativeBalanceAccounts.foreach(println)
    }

}