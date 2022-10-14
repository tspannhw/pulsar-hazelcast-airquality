package com.pulsardeveloper.pulsarhazelcastairquality;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Event {
        public String user;
        public Long eventCount;
        public String message;

        public Event() {
        }

        public Event(String user, Long eventCount, String message) {
            this.user = user;
            this.eventCount = eventCount;
            this.message = message;
        }
        public String getUser() {
            return user;
        }

        public Long getEventCount() {
            return eventCount;
        }

        public String getMessage() {
            return message;
        }

}
