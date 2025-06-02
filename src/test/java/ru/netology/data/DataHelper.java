package ru.netology.data;

import java.util.Objects;

public final class DataHelper {
    private DataHelper() {
    }

    public static class UserCredentials {
        private final String username;
        private final String passphrase;

        public UserCredentials(String username, String passphrase) {
            this.username = username;
            this.passphrase = passphrase;
        }

        public String getUsername() {
            return username;
        }

        public String getPassphrase() {
            return passphrase;
        }
    }

    public static UserCredentials getDefaultCredentials() {
        return new UserCredentials("vasya", "qwerty123");
    }

    public static class SecurityCode {
        private final String verificationDigits;

        public SecurityCode(String verificationDigits) {
            this.verificationDigits = verificationDigits;
        }

        public String getVerificationDigits() {
            return verificationDigits;
        }
    }

    public static SecurityCode getDefaultSecurityCode() {
        return new SecurityCode("12345");
    }

    public static class PaymentCard {
        private final String cardIdentifier;

        public PaymentCard(String cardIdentifier) {
            this.cardIdentifier = cardIdentifier;
        }

        public String getCardIdentifier() {
            return cardIdentifier;
        }
    }

    public static PaymentCard getPrimaryCard() {
        return new PaymentCard("5559 0000 0000 0001");
    }

    public static PaymentCard getSecondaryCard() {
        return new PaymentCard("5559 0000 0000 0002");
    }

    public static PaymentCard getCardDetails(String cardIdentifier) {
        switch (cardIdentifier) {
            case "5559 0000 0000 0001":
                return getPrimaryCard();
            case "5559 0000 0000 0002":
                return getSecondaryCard();
            default:
                return null;
        }
    }
}
