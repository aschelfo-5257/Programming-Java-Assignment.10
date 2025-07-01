import java.util.regex.*;

public class Symbol {
  public static void main(String [] args) {
    displayCount("(Animal)|(animal)"); // displayCount("(Name)|(name)");
    System.out.println();
    displayCount("(?i)(ANIMAL)"); // displayCount("(?i)(NAME)");
    System.out.println();

    displayCount("animal[^s]|(animal[s])"); // displayCount("name[^s]|(name[s])");
    displayCount("(animal[^s]|(animal[s])"); // displayCount("(name[^s]|(name[s])");
    displayCount("((animal[^s]|(animal[s]))"); // displayCount("((name[^s]|(name[s]))");
    displayCount("(?i)((animal[^s]|(animal[s]))"); // displayCount("(?i)((name[^s]|(name[s]))");
    System.out.println();
    /* 
    Note: Match grouping symbols in Java regex are parentheses (), which are used for grouping patterns and capturing parts of matched text.
    */
    Matcher m = Pattern.compile("(?i)((animal[^s])|(animal[s]))").matcher("The animal lives in National Zoo! The animals are friendly.");
    System.out.println(m.groupCount());

    int singular=0, plural=0;
    /*
Singular: A single pair of parentheses () creates a single capturing group. This group treats the characters within the parentheses as a single unit.
Plural: You can have multiple pairs of parentheses () within a single regular expression pattern, each creating a separate capturing group.
    */
    while (m.find()) {
      System.out.println("ordinary m.group() = " + m.group());
      System.out.println("m.group(2) = " + m.group(2));
      System.out.println("m.group(3) = " + m.group(3));
      System.out.println();
      if (m.group(2)!=null) { singular++; }
      if (m.group(3)!=null) { plural++; }
      /*
      Capturing groups are numbered from left to right based on their opening parentheses, starting at 1. The entire regex pattern is always considered group 0. For Example:
      
        while (matcher.find()) {
            System.out.println("Full Name: " + matcher.group(0));
            System.out.println("First Name: " + matcher.group(1));
            System.out.println("Last Name: " + matcher.group(2));
        }
      */
    }
    System.out.println("\nSingular animal usage: "+singular);
    System.out.println("Plural animals usage: "+plural);
  }

  static void displayCount(String regex) {
    Matcher m = Pattern.compile(regex).matcher(" ");
    System.out.println(regex + " m.groupCount() " + m.groupCount());
  }
}
