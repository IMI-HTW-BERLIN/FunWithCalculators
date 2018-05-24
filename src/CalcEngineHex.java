public class CalcEngineHex extends CalcEngine {
    private String displayText = "";
    protected boolean showingHex = false;

    public CalcEngineHex(){
        super();
    }

    @Override
    public void numberPressed(int number) {
        if (!showingHex) {
            super.numberPressed(number);
        } else {
            if(buildingDisplayValue) {
                // Incorporate this digit.
                displayValue = displayValue*16 + number;
            }
            else {
                // Start building a new number.
                displayValue = number;
                buildingDisplayValue = true;
            }
        }
    }

    protected void switchDecHex(){
        if(!showingHex){
            displayText = (Integer.toHexString(getDisplayValue())).toUpperCase();
            showingHex = true;
        }else{
            showingHex = false;
        }
    }


//    public String getDisplayText() {
//        return displayText;
//    }


    @Override
    public void clear() {
        super.clear();
        displayText = "0";
    }
}
