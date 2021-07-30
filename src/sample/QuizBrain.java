package sample;

public class QuizBrain {
    String object1;
    String object2;

    public QuizBrain(String object1, String object2){
        this.object1 = object1;
        this.object2 = object2;
    }


    public boolean isNumeric(String value) {
        if (value == null) {
            return false;
        }
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean isInteger(String value) {
        if (value == null) {
            return false;
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean checker(String choice){
        String result;

        if(isNumeric(object1)&&isNumeric(object2)){
            if(isInteger(object1)&&isInteger(object2)){
                result = Integer.toString(Integer.parseInt(object1)+Integer.parseInt(object2));
            }else{
                result = Double.toString(Double.parseDouble(object1)+ Double.parseDouble(object2));
            }
            if(object1.endsWith("f")||object2.endsWith("f")){
                result = result+'f';
            }
        }else {

            result = object1 + object2;
        }
        return choice.equals(result);

    }
}
