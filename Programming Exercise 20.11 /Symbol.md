## Match Grouping Symbols
In Java, match grouping symbols refer to the use of parentheses () in regular expressions (regex) to group parts of a pattern and capture matched substrings.

(Match grouping symbols) A Java program contains various pairs of grouping symbols, such as:

- Parentheses: ( and )

- Braces: { and }

- Brackets: [ and ]

Parentheses allow you to group multiple tokens and treat them as a single unit. For example, the regex (ab)+ matches "ab", "abab", "ababab", etc. When you use parentheses, the regex engine remembers the part of the string matched by the subexpression inside the parentheses. These are called <mark>**Capturing Groups**</mark>. You can refer to captured groups later in the pattern using \1, \2, etc., or in Java code using Matcher.group(int groupNumber).

- **Consider the string "{[()]}":**
    - {: Push { onto stack. Stack: [{]
    - [: Push [ onto stack. Stack: [{, []
    - (: Push ( onto stack. Stack: [{, [, (]
    - ): Pop (. Matches (. Stack: [{, []
    - ]: Pop [. Matches [. Stack: [{]
    - }: Pop {. Matches {. Stack: [] (empty)
  
    Since the stack is empty at the end, the grouping symbols are matched correctly.

**Symbol Tables**

|      Symbol      |             Purpose             |     Example     |
|------------------|---------------------------------|-----------------|
|    ()            |      Grouping & Capturing       |     (abc)+      |
|      (?: )       |      Non-capturing group        |    (?:abc)+     |
|    (?<name> )    | Named capturing group (Java 7+) |  (?<first>\w+)  |

Note: Pop the top element from the stack. This popped element should be the corresponding opening symbol for the current closing symbol. For example, if ) is encountered, the popped element should be (. If they don't match, it signifies an error (e.g., (a{b)} is illegal because ) closes { incorrectly).
