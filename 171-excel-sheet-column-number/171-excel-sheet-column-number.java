class Solution {
    public int titleToNumber(String columnTitle) {
        int columnNumber = 0;
    for(int i = 0; i < columnTitle.length(); i++)
        columnNumber = columnNumber * 26 + columnTitle.charAt(i) - 'A' + 1;
    return columnNumber;
    }
}