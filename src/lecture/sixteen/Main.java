package lecture.sixteen;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class Main {
    public static void main(String... args) {
        String randomFrom = "Random string ";
        String randomTo = "Random adressant";
        int randomSalary = 654132;

        Mail.MailMessage firstMessage = new Mail.MailMessage(
                "Robert Howard",
                "H.P. Lovecraft",
                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
        );

        assert firstMessage.getFrom().
                equals("Robert Howard") : "Wrong firstMessage from address";
        assert firstMessage.getTo().
                equals("H.P. Lovecraft") : "Wrong firstMessage to address";
        assert firstMessage.getContent().
                endsWith("Howard!") : "Wrong firstMessage content ending";

        Mail.MailMessage secondMessage = new Mail.MailMessage(
                "Jonathan Nolan",
                "Christopher Nolan",
                "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!"
        );

        Mail.MailMessage thirdMessage = new Mail.MailMessage(
                "Stephen Hawking",
                "Christopher Nolan",
                "Я так и не понял Интерстеллар."
        );

        List<Mail.MailMessage> messages = Arrays.asList(
                firstMessage, secondMessage, thirdMessage
        );

        Mail.MailService<String> mailService = new Mail.MailService<>();

        messages.stream()
                .forEachOrdered(mailService);

        Map<String, List<String>> mailBox = mailService.getMailBox();

        assert mailBox.get("H.P. Lovecraft")
                .equals(Arrays.asList("This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"))
                : "wrong mailService mailbox content (1)";

        assert mailBox.get("Christopher Nolan").
                equals(Arrays.asList("Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!",
                        "Я так и не понял Интерстеллар."))
                : "wrong mailService mailbox content (2)";

        assert mailBox.get(randomTo).
                equals(Collections.<String>emptyList()) : "wrong mailService mailbox content (3)";

        Mail.Salary salary1 = new Mail.Salary("Facebook", "Mark Zuckerberg", 1);
        Mail.Salary salary2 = new Mail.Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
        Mail.Salary salary3 = new Mail.Salary(randomFrom, randomTo, randomSalary);

        Mail.MailService<Integer> salaryService = new Mail.MailService<>();

        Arrays.asList(salary1, salary2, salary3).
                forEach(salaryService);

        Map<String, List<Integer>> salaries = salaryService.getMailBox();
        assert salaries.get(salary1.getTo()).
                equals(Arrays.asList(1)) : "wrong salaries mailbox content (1)";

        assert salaries.get(salary2.getTo()).
                equals(Arrays.asList(Integer.MAX_VALUE)) : "wrong salaries mailbox content (2)";

        assert salaries.get(randomTo).
                equals(Arrays.asList(randomSalary)) : "wrong salaries mailbox content (3)";
    }
}
