package w6d5.mauriziocrispino.Config;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailGun {
    public class MailgunSender {

        private String mailgunApiKey;
        private String mailgunDomainname;

        public MailgunSender(@Value("${mailgun.apikey}") String mailgunApiKey,
                             @Value("${mailgun.domainname}") String mailgunDomainName) {
            this.mailgunApiKey = mailgunApiKey;
            this.mailgunDomainname = mailgunDomainName;
        }

        public void sendRegistrationEmail(String recipient) {
            HttpResponse<JsonNode> response = Unirest.post("https://api.mailgun.net/v3/" + this.mailgunDomainname + "/messages")
                    .basicAuth("api", this.mailgunApiKey)
                    .queryString("from", "Maurizio <mauriziocrispino034@gmail.com>")
                    .queryString("to", recipient)
                    .queryString("subject", "Registrazione avvenuta con successo!")
                    .queryString("text", "Complimenti per esserti registrato!")
                    .asJson();
        }
    }
}
