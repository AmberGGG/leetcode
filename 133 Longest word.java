class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        ArrayList<String> result = new ArrayList<String>();
        int n = dictionary.length;
        int max = 0;
        for (int i = 0; i < n;i++){
            if (dictionary[i].length() > max){
                max = dictionary[i].length();
                result.clear();
                result.add(dictionary[i]);
            } else if (dictionary[i].length() == max){
                result.add(dictionary[i]);
            } 
        }
        return result;
    }
};