import java.time.LocalDateTime;
import java.time.Month;
import java.util.Random;
import java.util.Objects;

public class BankAccount {

    String Name;
    int Balance;
    LocalDateTime DateOfStart;
    boolean StatusBlock;
    String NumberAccount;

    BankAccount(String Name)
    {
        this.Name = Name;
        this.Balance = 100;
        this.DateOfStart = LocalDateTime.of(2022, Month.FEBRUARY, 22, 22,2);
        this.StatusBlock = false;
        this.NumberAccount = GenerateNumber();
    }

    private String GenerateNumber()
    {
        Random random = new Random();
        StringBuilder accountNumber =new StringBuilder();
        for(int i=0;i<8;i++){
            accountNumber.append(random.nextInt(10));
        }
        return NumberAccount=accountNumber.toString();
    }

    @Override
    public String toString() {
        return "BankAccount" +
                "\nName:" + Name +
                "\nBalance:" + Balance +
                "\nDateOfStart:" + DateOfStart +
                "\nStatusBlock:" + StatusBlock +
                "\nNumberAccount:'" + NumberAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(NumberAccount, that.NumberAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(NumberAccount);
    }

    public boolean Deposit (int amount)
    {
        if (!StatusBlock && amount > 0)
        {
            Balance += amount;
            return true;
        }
        return false;
    }

    public boolean Withdraw (int amount)
    {
        if (!StatusBlock && Balance >= amount)
        {
            Balance -= amount;
            return true;
        }
        return false;
    }

    public boolean Transfer (BankAccount otherAccount, int amount)
    {
        if ((!StatusBlock && !otherAccount.StatusBlock) && (Balance >= amount && amount >0))
        {
            Balance -= amount;
            otherAccount.Balance += amount;
            return true;
        }
        return false;
    }
}
