public class Permutations {
    /**
     * Recursively prints all different sorting of a given string.
     * 	uses an accumulator to store the data.
     * @param elements- the string we want to show all n! different sorting.
     * @param prefix - stores a partial subset of the string
     */
    private static void permutations(String elements, String prefix) {
        //TODO: Implement
        if (elements.length() == 0) {
            System.out.println(prefix);
        }
        else{
        for (int i = 0; i < elements.length(); i++) {
            char letter = elements.charAt(i);
            String str = elements.substring(0, i) + elements.substring(i + 1);
            if (str.length() == elements.length())
                  System.out.println(str);
            permutations(str, (prefix + letter) );
          }
        }
    }

    public static void main(String[] args) {

        int n= Integer.parseInt(args[0]);
        String letters= "a";
        for ( int i =1; i<n; i++){
            letters += (char)(97+ i);
        }

        permutations(letters, "");


        }
    }

