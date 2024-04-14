/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pl_project;

import java.util.HashSet;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 *
 * @author abdul
 */
public class PL_Project {
//        String line = "public static int( a, int b)"; // Replace this with the line of code you want to analyze

//        // Task 1: Check if the line is a comment
//        boolean is_Comment = isComment(line);
//        System.out.println("Is the line a comment? " + isComment);
    // Task 2: Check if identifiers are built-in language constructs
//        boolean isBuiltin = isBuiltinConstruct(line);
//        System.out.println("Are the identifiers built-in language constructs? " + isBuiltin);
//
//        // Task 3: Check if the line is a method declaration
//        boolean isMethodDeclaration = isMethodDeclaration(line);
//        System.out.println("Is the line a method declaration? " + isMethodDeclaration);
//
//        // Task 4: Check if the line belongs to a loop
//        boolean isInLoop = isInLoop(line);
//        System.out.println("Does the line belong to a loop? " + isInLoop);
//         String code = "if (x > 0) { // This is a comment\n" +
//                      "    System.out.println(\"Hello, world!\");\n" +
//                      "}\n" +
//                      "String str = \"Hello\";";
//        
//        String[] lines = code.split("\n");
//        for (int i = 0; i < lines.length; i++) {
//            checkIdentifiers(lines[i], i + 1);
//        }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String line1 = "public static void sum (int a, int b, int c, int c)";
        String line2 = "private void printMessage { System.out.println(msg); }";
        String line3 = "void calculate(float x, float y, z) { return x * y; }";
        String line8 = "float calculate(float x, float y, int y)";
        String line4 = "static String getName() { return name; }";
        String line5 = "public int[] getArray() { return array; }";
        String line6 = "public static void main(String[] args) { System.out.println(\"Hello, world!\"); }";
        String line9 = "public static void main(String[] args, String y) { System.out.println(\"Hello, world!\"); }";
        String line7 = "private void printMessage(int a, int b,) { System.out.println(msg); }";
        String line10 = "public ArrayList<String> getListOfStri8ngs88()";

        /*isFunctionHeader(line1);
        isFunctionHeader(line2);
        isFunctionHeader(line3);
        isFunctionHeader(line8);
        isFunctionHeader(line4);
        isFunctionHeader(line5);
        isFunctionHeader(line6);
        isFunctionHeader(line9);
        isFunctionHeader(line7);
        isFunctionHeader(line10);*/
        
//        forLoopType("for int j=0; j <= 10; j++) {");
//        forLoopType("for (int i=0; i <= 10; ++i) {");
//        forLoopType("for (int i=0; i <= 10; i+=2) {");
//        forLoopType("for (int i=0; i <= 10; i = i + 2) {");
//        forLoopType("for (int i=0; i <= 10; i--) {");
//        forLoopType("for (int i=0; i <= 10; i -= 2) {");
//        forLoopType("for (int i=0; i <= 10; i = i - 2) {");
//        forLoopType("for (int i=0; i <= 10; i *= 2) {");
//        forLoopType("for (int i=0; i <= 10; i += 2) {");
//        forLoopType("for (int i=0; i <= 10; i -= 2) {");
//        forLoopType("for (int i=0; i <= 10; i /= 2) {");
//        forLoopType("for (int i=0; i <= 10; i**2) {");
//        forLoopType("for (int i=0; i <= 10; i++2) {");
//        forLoopType("for (int i=0; i <= 10; i--2) {");
//        forLoopType("for (int i=0; i <= 10; i//2) {");
//        forLoopType("for (int i=0; i <= 10; i**2) {");
//        forLoopType("for (int i=0; i <= 10; i+) {");
//        forLoopType("for (int i=0; i <= 10; i-) {");
//        forLoopType("for (int i=0; i <= 10; i*) {");
//        forLoopType("for (int i=0; i <= 10; i/) {");
//        System.out.println("***********************************************************************************");
//        forLoopType("for (int i=0; i == 10; i++ {");
        
        
        whileLoopType("while (i< 10)");
        whileLoopType("while (i < 10");
        whileLoopType("while i < 10)");
        whileLoopType("while i < 10");
        whileLoopType("while (i 10)");
        whileLoopType("while (i < stre)");
        whileLoopType("whil (i < 10)");
        whileLoopType("while (i <== 10)");
        whileLoopType("while (sda > aopds)");
        whileLoopType("while ( i === 10) Error");
        whileLoopType("while (i != 10) { }");
        whileLoopType("while (i !== 10) Error");
        whileLoopType("while (i == 10)");
        whileLoopType("while (i >== 10)");
        whileLoopType("while (int i = 2 > 23)");
        whileLoopType("while (I == 3)");
        



        
        
    }
    public static void loopType(){
        
    }
    public static void whileLoopType(String line) {
        String[] varPrimitiveTypes = { "String", "int", "double", "boolean", "char", "long", "float", "byte", "short" };
        String[] comparisonOperators = { "==", "!=", ">", ">=", "<", "<=" };
        // Extracting the function header (method signature) without the body
        int bodyIndex = line.indexOf('{');
        String header = bodyIndex != -1 ? line.substring(0, bodyIndex).trim() : line.trim();
        
        // Join the comparison operators into a regex group
        String comparisonOperatorsRegex = "(" + String.join("|", comparisonOperators) + ")";
        String primitiveTypes = "(" + String.join("|", varPrimitiveTypes) + ")";
        String variable_NameRegex = "\\b[a-zA-Z_][a-zA-Z0-9_]*\\b";

        String whileLoopPattern = "^\\s*while\\s*\\(\\s*+(" + variable_NameRegex + ")\\s*" + comparisonOperatorsRegex + "\\s*(\\d|\\w)+\\s*\\)\\s*.*";

        // Check if the line matches the while loop pattern
        if (line.matches(whileLoopPattern)) {
            System.out.println("Line no: " + header + " --> : belongs to while loop");
        } else {
            System.out.println("Line no: " + header + " --> : does not belong to while loop");
        }

    }
    public static void forLoopType(String line) {
    String[] varPrimitiveTypes = { "String", "int", "double", "boolean", "char", "long", "float", "byte", "short" };
    String[] comparisonOperators = { "==", "!=", ">", ">=", "<", "<=" };

    // Extracting the function header (method signature) without the body
    int bodyIndex = line.indexOf('{');
    String header = bodyIndex != -1 ? line.substring(0, bodyIndex).trim() : line.trim();

    // Join the comparison operators into a regex group
    String comparisonOperatorsRegex = "(" + String.join("|", comparisonOperators) + ")";
    String primitiveTypes = "(" + String.join("|", varPrimitiveTypes) + ")";
    String variable_NameRegex = "\\b[a-zA-Z_][a-zA-Z0-9_]*\\b";
    

    // Modified forLoopPattern to use backreferences to ensure the same variable name is used
    String forLoopPattern = "^\\s*for\\s*\\(\\s*" + primitiveTypes + "\\s+(" + variable_NameRegex + ")\\s*=\\s*\\d+\\s*;\\s*\\2\\s*" + comparisonOperatorsRegex + "\\s*\\d+\\s*;\\s*(\\2\\s*(\\+\\+|--)|\\s*(\\+\\+|--)\\s*\\2|\\2\\s*[\\+\\-\\*\\/]=\\s*\\d+|\\2\\s*=\\s*\\2\\s*[\\+\\-\\*\\/]\\s*\\d+)\\)\\s*.*";

    // Check if the line matches the for loop pattern
    if (header.matches(forLoopPattern)) {
        System.out.println(header + " --> is a valid for loop header.");
    } else {
        System.out.println(header + " --> is not a valid for loop header.");
    }
}

    /*public static void loopType(String line) {
        String[] logicalOperators = { "&&", "||", "!" };
        String[] varPrimitiveTypes = { "String", "int", "double", "boolean", "char", "long", "float", "byte", "short" };
        String[] comparisonOperators = { "==", "===", "!=", ">", ">=", "<", "<=" };

        // Extracting the function header (method signature) without the body
        int bodyIndex = line.indexOf('{');
        String header = bodyIndex != -1 ? line.substring(0, bodyIndex).trim() : line.trim();

        // Join the comparison operators into a regex group
        String comparisonOperatorsRegex = "(" + String.join("|", comparisonOperators) + ")";
        String primitiveTypes = "(" + String.join("|", varPrimitiveTypes) + ")";
        String variable_NameRegex = "\\b[a-zA-Z_][a-zA-Z0-9_]*\\b";
        String forLoopPattern = "^\\s*for\\s*\\(\\s*" + primitiveTypes + "\\s+" + variable_NameRegex + "\\s*=\\s*\\d+\\s*;\\s*(" + variable_NameRegex + "\\s*(==|===|!=|>|>=|<|<=|\\*|\\+|-|/)\\s*\\d+|(" + variable_NameRegex + "\\s*(\\*|\\+|-|/)\\s*\\d+\\s*)?)\\s*;\\s*(" + variable_NameRegex + "\\s*(\\+\\+|--)|(\\+\\+|--\\s*)" + variable_NameRegex + "|" + variable_NameRegex + "\\s*[\\+\\-\\*\\/]=\\s*\\d+|" + variable_NameRegex + "\\s*=\\s*" + variable_NameRegex + "\\s*[\\+\\-\\*\\/]\\s*\\d+)\\s*.*";

        // Check if the line matches the for loop pattern
        if (header.matches(forLoopPattern)) {
            System.out.println(header + " --> contains a for loop.");
        } else {
            System.out.println(header + " --> does not contain a for loop.");
        }
    }*/
     
    // This code is all good excpet the TODO
    public static void isFunctionHeader(String line) {
        // Define 3 arrays of all types
        String[] nonPrimitiveTypes = {"Byte", "Short", "Integer", "Long", "Float", "Double", "Boolean", "Character", "String"};
        String[] collectionsNonprimitiveTypes = {"ArrayList", "HashSet", "Set", "LinkedList", "TreeSet", "TreeMap", "Stack", "Queue"};
        String[] varPrimitiveTypes = {"String", "int", "double", "boolean", "char", "long", "float", "byte", "short"};

        // Extracting the function header (method signature) without the body
        int bodyIndex = line.indexOf('{');
        String header = bodyIndex != -1 ? line.substring(0, bodyIndex).trim() : line.trim();

        // TODO:
        // Parameters name Duplication
        
        // Modifiers Regex
        String modifiersRegex = "^((public|private|protected|\\s)*\\s*)(static\\s+)?";

        // ReturnT types Regex
        String returnTypeRegex = "(" + String.join("|", varPrimitiveTypes) + "|void|" + String.join("|", collectionsNonprimitiveTypes) + ")(\\[\\]|<(" + String.join("|", nonPrimitiveTypes) + ")>)?\\s+";

        // Function name & variables Regex
        String function_variable_NameRegex = "\\b[a-zA-Z_][a-zA-Z0-9_]*\\b";

        // Parameters Regex
        String parameters = "\\s*\\(\\s*((" + String.join("|", varPrimitiveTypes) + "|" + String.join("|", collectionsNonprimitiveTypes)
                + ")(\\[\\]|<" + String.join("|", nonPrimitiveTypes) + ">)?+\\s" + function_variable_NameRegex + "\\s*(,\\s*("
                + String.join("|", varPrimitiveTypes) + "|" + String.join("|", collectionsNonprimitiveTypes)
                + ")(\\[\\]|<" + String.join("|", nonPrimitiveTypes) + ">)?+\\s" + function_variable_NameRegex + "\\s*)*)?\\)\\s*$";

        // Merged Regex
        String fullMethodDeclarationRegex = modifiersRegex + returnTypeRegex + function_variable_NameRegex + parameters;

        // Check if the function header matches any of the patterns
        if (header.matches(fullMethodDeclarationRegex)) {
            System.out.println(header + " --> is a valid function header");
        } else {
            System.out.println(header + " --> is not a valid function header");
        }
        
    }
 /*
    String regex = "^((public|private|protected|\\s)*\\s*)(static\\s+)?(" + 
    String.join("|", varPrimitiveTypes) + "|void|"+String.join("|", collectionsNonprimitiveTypes)+
    ")(\\[\\]|<("+ String.join("|", nonPrimitiveTypes)+")>)?\\s+" +
    "\\b[a-zA-Z_][a-zA-Z0-9_]*\\b" +
    "\\s*\\(\\s*((" + String.join("|", varPrimitiveTypes) + "|"+String.join("|", collectionsNonprimitiveTypes)+
    ")(\\[\\]|<"+ String.join("|", nonPrimitiveTypes)+">)?+\\s"+"\\b[a-zA-Z_][a-zA-Z0-9_]*\\b"+"\\s*(,\\s*(" + 
    String.join("|", varPrimitiveTypes)+ "|"+String.join("|", collectionsNonprimitiveTypes)+
    ")(\\[\\]|<"+ String.join("|", nonPrimitiveTypes)+">)?+\\s"+"\\b[a-zA-Z_][a-zA-Z0-9_]*\\b"+"\\s*)*)?\\)\\s*$";
     */

    public static void checkIdentifiers(String line, int lineNumber) {
        
        ArrayList<String> identifiers = new ArrayList<>(Arrays.asList("if", "for", "while", "switch", "case", "break", "continue",
                "return", "try", "catch", "finally", "throw", "throws",
                "class", "interface", "enum", "public", "private",
                "protected", "static", "final", "void", "int", "long",
                "float", "double", "boolean", "char", "String"));

        // Check for comments
        if (line.trim().startsWith("//") || line.trim().startsWith("/*") || line.trim().endsWith("*/")) {
            return;
        }

        // Split line into words
        String[] words = line.split("\\b");
        for (String word : words) {
            // Check if the word is an identifier
            String identifier = word.trim();
            if (!identifier.isEmpty() && identifiers.contains(identifier)) {
                System.out.println("Line no: " + lineNumber + " --> " + identifier + ": is a built-in language construct");   
            }
        }
        
        // If no built-in constructs found in the line
        System.out.println("Line no: " + lineNumber + " --> No built-in language constructs found");
    }

}

