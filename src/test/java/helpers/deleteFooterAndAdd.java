package helpers;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class deleteFooterAndAdd {
    public deleteFooterAndAdd deleteFooterAndAdd(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#app footer').remove()");
        return this;
    }
}
