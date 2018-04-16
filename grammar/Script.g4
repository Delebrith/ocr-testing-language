grammar Script;

/*
 * Parser Rules
 */

script
    : (functionDefinition)* ;

functionDefinition
    : TYPE ID parameters instructionSet;

parameters
    : OPEN_ROUND_BRACKETS (TYPE ID (COMA TYPE ID)*)? CLOSE_ROUND_BRACKETS;

instructionSet
    : OPEN_CURLY_BRACKETS (statement)* CLOSE_CURLY_BRACKETS;

statement
    : ifStatement
    | whileStatement
    | returnStatement SEMICOLON
    | declarationStatement SEMICOLON
    | assignmentStatement SEMICOLON
    | functionInvocation SEMICOLON;

ifStatement
    : IF condition instructionSet (( ELSEIF condition instructionSet )* ELSE instructionSet)? ;

whileStatement
    : WHILE condition instructionSet;

returnStatement
    : RETURN value;

declarationStatement
    : TYPE ID ( ASSIGNMENT_OP value)?;

assignmentStatement
    : ID ASSIGNMENT_OP value;

functionInvocation
    : ID arguments;

arguments
    : OPEN_ROUND_BRACKETS ( value (COMA value)* )? CLOSE_ROUND_BRACKETS;


numericOperation
    : OPEN_ROUND_BRACKETS sum CLOSE_ROUND_BRACKETS;

sum
    : multiplication ( ( PLUS_OP | MINUS_OP ) multiplication )*;

multiplication
    : singleOperation ( ( MULTIPLICATION_OP | DIVISION_OP ) singleOperation )*;

singleOperation
    : ( MINUS_OP )? ( numericOperation | functionInvocation | idAtom | integerAtom | textAtom);


condition
    : OPEN_ROUND_BRACKETS alternative CLOSE_ROUND_BRACKETS;

alternative
    : cojunction ( OR_OP cojunction )*;

cojunction
    : cojunctionOperand ( AND_OP cojunctionOperand )*;

cojunctionOperand
    : comparison | singleCondition;

comparison
    : ( atom | functionInvocation | condition | sum  )
        COMPARISON_OP ( atom | functionInvocation | condition | sum  );

singleCondition
    : ( NEGATION_OP )? ( booleanAtom | functionInvocation | condition | idAtom);

value
    : atom
    | functionInvocation
    | sum
    | alternative;

atom
    : integerAtom
    | booleanAtom
    | idAtom
    | textAtom;

integerAtom
    : INTEGER_VARIABLE;

booleanAtom
    : TRUE | FALSE;

textAtom
    : TEXT_VARIABLE;

idAtom
    : ID;

/*
 * Lexer Rules
 */

TYPE : 'Text' | 'Image' | 'Integer' | 'Void' | 'Boolean' ;
OPEN_ROUND_BRACKETS : '(';
CLOSE_ROUND_BRACKETS : ')';
OPEN_CURLY_BRACKETS : '{';
CLOSE_CURLY_BRACKETS : '}';
SEMICOLON : ';';
IF : 'if';
ELSE : 'else';
ELSEIF : 'elseif';
WHILE : 'while';
BREAK : 'break';
CONTINUE : 'continue';
RETURN : 'return';
ASSIGNMENT_OP : '=';
OR_OP : '||';
AND_OP : '&&';
COMPARISON_OP : '==' | '!=' | '<' | '>' | '<=' | '>=' ;
NEGATION_OP : '!';
PLUS_OP : '+';
MINUS_OP : '-';
MULTIPLICATION_OP : '*';
DIVISION_OP : '/';
QUOTATION : '"';
TRUE : 'true';
FALSE: 'false';
ID : [a-zA-Z] [a-zA-Z0-9]* ;
INTEGER_VARIABLE : [0-9] | [1-9][0-9]*;
TEXT_VARIABLE : QUOTATION (~('"') | ('\\' ('"')))* QUOTATION;
COMA : ',';

COMMENT : '#' ~[\n\r]* -> skip;
WHITESPACE : (' ' | [\n\t\r]) -> skip ;
