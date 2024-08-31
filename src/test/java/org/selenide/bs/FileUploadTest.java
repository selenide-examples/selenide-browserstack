package org.selenide.bs;

import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@ExtendWith({TestSetup.class, TextReportExtension.class})
class FileUploadTest {
  @Test
  void canUploadFile() throws IOException {
    File file = createTemporaryFile();

    open("https://the-internet.herokuapp.com/upload");
    $("#file-upload").uploadFile(file);
    $("#file-submit").click();
    $("#uploaded-files").shouldHave(text(file.getName()));
  }

  private File createTemporaryFile() throws IOException {
    File tempFile = File.createTempFile("selenide-browserstack.", ".temp.txt");
    try (Writer w = new FileWriter(tempFile)) {
      w.write("Hello, world!");
    }
    return tempFile;
  }
}
