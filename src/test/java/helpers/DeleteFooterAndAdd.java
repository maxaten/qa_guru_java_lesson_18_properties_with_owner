package helpers;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class DeleteFooterAndAdd {
    public DeleteFooterAndAdd deleteFooterAndAdd(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#app footer').remove()");
        return this;
    }
}
