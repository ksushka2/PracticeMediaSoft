public class Main {
    public static void main(String[] args) {

        BankAccount KseniaAccount = new BankAccount("Ksenia");
        BankAccount NikitaAccount = new BankAccount("Nikita");

        System.out.println(KseniaAccount);
        System.out.println(NikitaAccount);

        System.out.println("Equal?");
        System.out.println(KseniaAccount.equals(NikitaAccount));

        System.out.println("Testing methods");
        System.out.println("Deposit:");
        System.out.println(KseniaAccount.Deposit(20));
        System.out.println(KseniaAccount.Balance);
        System.out.println("Withdraw:");
        System.out.println(KseniaAccount.Withdraw(10));
        System.out.println(KseniaAccount.Balance);
        System.out.println("Transfer:");
        System.out.println(KseniaAccount.Transfer(NikitaAccount,50));
        System.out.println(KseniaAccount.Balance);
        }
    }
