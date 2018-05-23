public class NewCalcEngine extends CalcEngine {
    public NewCalcEngine() {
    }

    public void multi() {
        applyOperator('*');
    }

    public void div(){
        applyOperator('/');
    }

    @Override
    protected void calculateResult()
    {
        switch(lastOperator) {
            case '+':
                displayValue = leftOperand + displayValue;
                haveLeftOperand = true;
                leftOperand = displayValue;
                break;
            case '-':
                displayValue = leftOperand - displayValue;
                haveLeftOperand = true;
                leftOperand = displayValue;
                break;
            case '*':
                displayValue *= leftOperand;
                haveLeftOperand = true;
                leftOperand = displayValue;
                break;
            case '/':
                displayValue /= leftOperand;
                haveLeftOperand = true;
                leftOperand = displayValue;
                break;
            default:
                keySequenceError();
                break;
        }
    }



}
