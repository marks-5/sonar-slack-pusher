package org.jenkinsci.plugins.sonarslackpusher;

public class Attachment {

   private String alert;
   private String color;
   private String alertText;

   public String getAttachment() {
      return "{\"text\":\"*" + alert
         + "*\\n*Reason:*\\n" + alertText
         + "\",\"color\":\"" + color
         + "\",\"mrkdwn_in\": [\"text\"]}";
   }

   public void setAlert(String alert) {
      this.alert = alert.equalsIgnoreCase("ERROR") ? "DANGER" : "WARNING";
      this.color = alert.equalsIgnoreCase("ERROR") ? "danger" : "warning";
   }

   public void setAlertText(String alertText) {
      String alerts = alertText.replaceAll(",", "\\\\n-");
      this.alertText = "- " + alerts;
   }
}
