// MARK: Plain Text
// This is a plain text comment to test the plain text color.

// MARK: Comments
// This is a single-line comment.
/*
 This is a multi-line comment.
 */

// MARK: Documentation Markup
/**
 This is a documentation comment.
 - Note: This section is for Documentation Markup Keywords.
 */

// MARK: Documentation Markup Keywords
/// - Parameters: parameter1, parameter2
/// - Returns: A value
/// - Throws: An error if something goes wrong.

// MARK: Marks
// MARK: This is a mark for organization

// MARK: Strings
let greeting: String = "Hello, World!"

// MARK: Characters
let firstCharacter: Character = "H"

// MARK: Numbers
let integerNumber: Int = 42
let floatingPointNumber: Double = 3.14

// MARK: Regex Literals
let regexPattern = #"\d{3}-\d{2}-\d{4}"# // Regex for a pattern like 123-45-6789

// MARK: Regex Literal Numbers
let regexNumber = #"\d+"# // Matches one or more digits

// MARK: Regex Literal Capture Names
let captureName = #"(?<area>\d{3})"# // Captures area code as "area"

// MARK: Regex Literal Character Class Names
let characterClass1 = #"[A-Za-z]"#   // Matches uppercase and lowercase letters
let characterClass2 = #"[0-9]"#      // Matches digits 0-9
let characterClass3 = #"[a-z]"#      // Matches lowercase letters
let characterClass4 = #"[A-Z]"#      // Matches uppercase letters
let characterClass5 = #"\w"#         // Matches word characters (alphanumeric + _)
let characterClass6 = #"\d"#         // Matches digits (0-9)
let characterClass7 = #"\s"#         // Matches whitespace characters
let characterClass8 = #"[a-zA-Z_]"#  // Matches lowercase, uppercase, and underscore
let characterClass9 = #"[^\w]"#      // Matches non-word characters

// MARK: Regex Literal Operators
let regexOperator = #"|"# // Logical OR in regex

// MARK: Keywords
class MyClass {}
for i in 1...3 {
    print(i)
}
if true {
    print("Conditional test.")
}

// MARK: Preprocessor Statements
#if DEBUG
print("Debug mode")
#else
print("Release mode")
#endif

// MARK: URLs
let website = "https://example.com"

// MARK: Attributes
@available(iOS 15.0, *)
func newFeature() {}

// MARK: Type Declarations
typealias StringDict = [String: String]

// MARK: Other Declarations
let constantValue = 10
var variableValue = 20

// MARK: Project Class Names
class ProjectClass {}

// MARK: Project Function and Method Names
func projectFunction() {}

// MARK: Project Constants
let projectConstant = "Project"

// MARK: Project Type Names
struct ProjectStruct {}

// MARK: Project Properties and Globals
var projectGlobalVariable = "Global"

// MARK: Project Preprocessor Macros
// Preprocessor macros typically don’t appear in Swift directly

// MARK: Other Class Names
class OtherClass {}

// MARK: Other Function and Method Names
func otherFunction() {}

// MARK: Other Constants
let otherConstant = "Other"

// MARK: Other Type Names
struct OtherStruct {}

// MARK: Other Properties and Globals
var otherGlobalVariable = "OtherGlobal"

// MARK: Other Preprocessor Macros
// Preprocessor macros for non-project elements

// MARK: Heading
// This is a heading comment to test "Heading" style.
