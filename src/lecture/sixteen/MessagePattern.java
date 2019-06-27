package lecture.sixteen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

class Mail {
    public interface MessagePattern<T> {
        String getFrom();

        String getTo();

        T getContent();
    }

    public static class MailMessage implements MessagePattern<String> {
        private String from;
        private String to;
        private String content;

        public MailMessage(String from, String to, String content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public String getContent() {
            return content;
        }
    }

    public static class Salary implements MessagePattern<Integer> {
        private String from;
        private String to;
        private Integer content;

        public Salary(String from, String to, Integer content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public Integer getContent() {
            return content;
        }
    }

    public static class MailService<T> implements Consumer<MessagePattern<T>> {
        private Map<String, List<T>> mailBox = new HashMap<String, List<T>>() {
            @Override
            public List<T> get(Object key) {
                return getOrDefault(key, Collections.emptyList());
            }
        };

        @Override
        public void accept(MessagePattern<T> messagePattern) {
            List<T> list = mailBox.get(messagePattern.getTo());
            if (list.isEmpty()) {
                list = new ArrayList<>();
            }
            list.add(messagePattern.getContent());
            mailBox.put(messagePattern.getTo(), list);
        }

        public Map<String, List<T>> getMailBox() {
            return mailBox;
        }
    }
}
