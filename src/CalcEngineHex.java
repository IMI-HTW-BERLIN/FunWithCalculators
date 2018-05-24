public class CalcEngineHex extends CalcEngine {
    private String displayText = "";
    protected boolean showingHex = false;

    /**
     * Creates a new calculator engine using superclass. Adds the functionality to calculate in hexadecimal
     */
    public CalcEngineHex(){
        super();
    }

    /**
     * Calculating in Hexadecimal.
     * This overrides the original numberPressed method. If you using the Hexadecimal calculation,
     * this will calculate in Hexadecimal by changing the display-value differently.
     * @param number The number pressed on the calculator.
     */
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

    /**
     * Changes current display-value to hexadecimal or decimal.
     * Also adds/removes buttons depending on that.
     */
    protected void switchDecHex(){
        if(!showingHex){
            displayText = (Integer.toHexString(getDisplayValue())).toUpperCase();
            showingHex = true;
        }else{
            showingHex = false;
        }
    }
    /**
     * Clears the Hexadecimal display-value.
     */
    @Override
    public void clear() {
        super.clear();
        displayText = "0";
    }
}
