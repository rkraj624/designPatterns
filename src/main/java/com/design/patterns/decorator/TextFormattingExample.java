package com.design.patterns.decorator;

public class TextFormattingExample {
    public  interface Text{
        String getContent();
    }
    public static class PlainText implements Text {
        private String content;
        public PlainText(String content){
            this.content = content;
        }
        @Override
        public String getContent() {
            return content;
        }
    }
    public static class TextDecorator implements Text{
        private Text text;
        public TextDecorator(Text textDecorator){
            this.text = textDecorator;
        }
        @Override
        public String getContent() {
            return text.getContent();
        }
    }
    public static class BoldText extends TextDecorator {
        public BoldText(Text decoratorText) {
            super(decoratorText);
        }
        @Override
        public String getContent() {
            return "<b>" + super.getContent() + "</b>";
        }
    }
     public static class ItalicText extends TextDecorator {
        public ItalicText(Text decoratorText) {
            super(decoratorText);
        }
        @Override
        public String getContent() {
            return "<i>" + super.getContent() + "</i>";
        }
    }
     public static class UnderLineText extends TextDecorator {
        public UnderLineText(Text decoratorText) {
            super(decoratorText);
        }
        @Override
        public String getContent() {
            return "<ul>" + super.getContent() + "</ul>";
        }
    }
    public static void main(String[] args) {
        Text plainText = new PlainText("Hello, world!");
        Text boldText = new BoldText(plainText);
        Text italicText = new ItalicText(boldText);
        Text formattedText = new UnderLineText(italicText);
        System.out.println(formattedText.getContent());
    }
}
