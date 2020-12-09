public class Item {
    public String question ;
    public String reponse ;

    public Item() {
        this.question = "";
        this.reponse = "";
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String obtenirBonneRéponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public Boolean testerReponse (String r) {
        return this.reponse.equals(r);
    }

    @Override
    public String toString() {
        return "Item{" +
                "question='" + question + '\'' +
                ", reponse='" + reponse + '\'' +
                '}';
    }
}
