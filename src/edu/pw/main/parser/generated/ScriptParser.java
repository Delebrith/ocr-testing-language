package edu.pw.main.parser.generated;// Generated from Script.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TYPE=1, OPEN_ROUND_BRACKETS=2, CLOSE_ROUND_BRACKETS=3, OPEN_CURLY_BRACKETS=4, 
		CLOSE_CURLY_BRACKETS=5, SEMICOLON=6, IF=7, ELSE=8, ELSEIF=9, WHILE=10, 
		BREAK=11, CONTINUE=12, RETURN=13, ASSIGNMENT_OP=14, OR_OP=15, AND_OP=16, 
		COMPARISON_OP=17, NEGATION_OP=18, PLUS_OP=19, MINUS_OP=20, MULTIPLICATION_OP=21, 
		DIVISION_OP=22, QUOTATION=23, TRUE=24, FALSE=25, ID=26, INTEGER_VARIABLE=27, 
		TEXT_VARIABLE=28, COMA=29, COMMENT=30, WHITESPACE=31;
	public static final int
		RULE_script = 0, RULE_functionDefinition = 1, RULE_parameters = 2, RULE_instructionSet = 3, 
		RULE_statement = 4, RULE_ifStatement = 5, RULE_whileStatement = 6, RULE_returnStatement = 7, 
		RULE_declarationStatement = 8, RULE_assignmentStatement = 9, RULE_functionInvocation = 10, 
		RULE_arguments = 11, RULE_numericOperation = 12, RULE_sum = 13, RULE_multiplication = 14, 
		RULE_singleOperation = 15, RULE_condition = 16, RULE_alternative = 17, 
		RULE_cojunction = 18, RULE_cojunctionOperand = 19, RULE_comparison = 20, 
		RULE_singleCondition = 21, RULE_value = 22, RULE_atom = 23, RULE_integerAtom = 24, 
		RULE_booleanAtom = 25, RULE_textAtom = 26, RULE_idAtom = 27;
	public static final String[] ruleNames = {
		"script", "functionDefinition", "parameters", "instructionSet", "statement", 
		"ifStatement", "whileStatement", "returnStatement", "declarationStatement", 
		"assignmentStatement", "functionInvocation", "arguments", "numericOperation", 
		"sum", "multiplication", "singleOperation", "condition", "alternative", 
		"cojunction", "cojunctionOperand", "comparison", "singleCondition", "value", 
		"atom", "integerAtom", "booleanAtom", "textAtom", "idAtom"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'('", "')'", "'{'", "'}'", "';'", "'if'", "'else'", "'elseif'", 
		"'while'", "'break'", "'continue'", "'return'", "'='", "'||'", "'&&'", 
		null, "'!'", "'+'", "'-'", "'*'", "'/'", "'\"'", "'true'", "'false'", 
		null, null, null, "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TYPE", "OPEN_ROUND_BRACKETS", "CLOSE_ROUND_BRACKETS", "OPEN_CURLY_BRACKETS", 
		"CLOSE_CURLY_BRACKETS", "SEMICOLON", "IF", "ELSE", "ELSEIF", "WHILE", 
		"BREAK", "CONTINUE", "RETURN", "ASSIGNMENT_OP", "OR_OP", "AND_OP", "COMPARISON_OP", 
		"NEGATION_OP", "PLUS_OP", "MINUS_OP", "MULTIPLICATION_OP", "DIVISION_OP", 
		"QUOTATION", "TRUE", "FALSE", "ID", "INTEGER_VARIABLE", "TEXT_VARIABLE", 
		"COMA", "COMMENT", "WHITESPACE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Script.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ScriptContext extends ParserRuleContext {
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitScript(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_script);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(56);
				functionDefinition();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(ScriptParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(ScriptParser.ID, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public InstructionSetContext instructionSet() {
			return getRuleContext(InstructionSetContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functionDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(TYPE);
			setState(63);
			match(ID);
			setState(64);
			parameters();
			setState(65);
			instructionSet();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public TerminalNode OPEN_ROUND_BRACKETS() { return getToken(ScriptParser.OPEN_ROUND_BRACKETS, 0); }
		public TerminalNode CLOSE_ROUND_BRACKETS() { return getToken(ScriptParser.CLOSE_ROUND_BRACKETS, 0); }
		public List<TerminalNode> TYPE() { return getTokens(ScriptParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(ScriptParser.TYPE, i);
		}
		public List<TerminalNode> ID() { return getTokens(ScriptParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ScriptParser.ID, i);
		}
		public List<TerminalNode> COMA() { return getTokens(ScriptParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(ScriptParser.COMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(OPEN_ROUND_BRACKETS);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(68);
				match(TYPE);
				setState(69);
				match(ID);
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(70);
					match(COMA);
					setState(71);
					match(TYPE);
					setState(72);
					match(ID);
					}
					}
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(80);
			match(CLOSE_ROUND_BRACKETS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionSetContext extends ParserRuleContext {
		public TerminalNode OPEN_CURLY_BRACKETS() { return getToken(ScriptParser.OPEN_CURLY_BRACKETS, 0); }
		public TerminalNode CLOSE_CURLY_BRACKETS() { return getToken(ScriptParser.CLOSE_CURLY_BRACKETS, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public InstructionSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructionSet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitInstructionSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionSetContext instructionSet() throws RecognitionException {
		InstructionSetContext _localctx = new InstructionSetContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instructionSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(OPEN_CURLY_BRACKETS);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE) | (1L << IF) | (1L << WHILE) | (1L << RETURN) | (1L << ID))) != 0)) {
				{
				{
				setState(83);
				statement();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
			match(CLOSE_CURLY_BRACKETS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ScriptParser.SEMICOLON, 0); }
		public DeclarationStatementContext declarationStatement() {
			return getRuleContext(DeclarationStatementContext.class,0);
		}
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		try {
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				ifStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				whileStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				returnStatement();
				setState(94);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(96);
				declarationStatement();
				setState(97);
				match(SEMICOLON);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(99);
				assignmentStatement();
				setState(100);
				match(SEMICOLON);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(102);
				functionInvocation();
				setState(103);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(ScriptParser.IF, 0); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<InstructionSetContext> instructionSet() {
			return getRuleContexts(InstructionSetContext.class);
		}
		public InstructionSetContext instructionSet(int i) {
			return getRuleContext(InstructionSetContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(ScriptParser.ELSE, 0); }
		public List<TerminalNode> ELSEIF() { return getTokens(ScriptParser.ELSEIF); }
		public TerminalNode ELSEIF(int i) {
			return getToken(ScriptParser.ELSEIF, i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(IF);
			setState(108);
			condition();
			setState(109);
			instructionSet();
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE || _la==ELSEIF) {
				{
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ELSEIF) {
					{
					{
					setState(110);
					match(ELSEIF);
					setState(111);
					condition();
					setState(112);
					instructionSet();
					}
					}
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(119);
				match(ELSE);
				setState(120);
				instructionSet();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(ScriptParser.WHILE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public InstructionSetContext instructionSet() {
			return getRuleContext(InstructionSetContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(WHILE);
			setState(124);
			condition();
			setState(125);
			instructionSet();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(ScriptParser.RETURN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(RETURN);
			setState(128);
			value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationStatementContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(ScriptParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(ScriptParser.ID, 0); }
		public TerminalNode ASSIGNMENT_OP() { return getToken(ScriptParser.ASSIGNMENT_OP, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public DeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationStatementContext declarationStatement() throws RecognitionException {
		DeclarationStatementContext _localctx = new DeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declarationStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(TYPE);
			setState(131);
			match(ID);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT_OP) {
				{
				setState(132);
				match(ASSIGNMENT_OP);
				setState(133);
				value();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentStatementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ScriptParser.ID, 0); }
		public TerminalNode ASSIGNMENT_OP() { return getToken(ScriptParser.ASSIGNMENT_OP, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(ID);
			setState(137);
			match(ASSIGNMENT_OP);
			setState(138);
			value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionInvocationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ScriptParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public FunctionInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionInvocation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitFunctionInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionInvocationContext functionInvocation() throws RecognitionException {
		FunctionInvocationContext _localctx = new FunctionInvocationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(ID);
			setState(141);
			arguments();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public TerminalNode OPEN_ROUND_BRACKETS() { return getToken(ScriptParser.OPEN_ROUND_BRACKETS, 0); }
		public TerminalNode CLOSE_ROUND_BRACKETS() { return getToken(ScriptParser.CLOSE_ROUND_BRACKETS, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(ScriptParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(ScriptParser.COMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(OPEN_ROUND_BRACKETS);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_ROUND_BRACKETS) | (1L << NEGATION_OP) | (1L << MINUS_OP) | (1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER_VARIABLE) | (1L << TEXT_VARIABLE))) != 0)) {
				{
				setState(144);
				value();
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(145);
					match(COMA);
					setState(146);
					value();
					}
					}
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(154);
			match(CLOSE_ROUND_BRACKETS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericOperationContext extends ParserRuleContext {
		public TerminalNode OPEN_ROUND_BRACKETS() { return getToken(ScriptParser.OPEN_ROUND_BRACKETS, 0); }
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public TerminalNode CLOSE_ROUND_BRACKETS() { return getToken(ScriptParser.CLOSE_ROUND_BRACKETS, 0); }
		public NumericOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericOperation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitNumericOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericOperationContext numericOperation() throws RecognitionException {
		NumericOperationContext _localctx = new NumericOperationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_numericOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(OPEN_ROUND_BRACKETS);
			setState(157);
			sum();
			setState(158);
			match(CLOSE_ROUND_BRACKETS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SumContext extends ParserRuleContext {
		public List<MultiplicationContext> multiplication() {
			return getRuleContexts(MultiplicationContext.class);
		}
		public MultiplicationContext multiplication(int i) {
			return getRuleContext(MultiplicationContext.class,i);
		}
		public List<TerminalNode> PLUS_OP() { return getTokens(ScriptParser.PLUS_OP); }
		public TerminalNode PLUS_OP(int i) {
			return getToken(ScriptParser.PLUS_OP, i);
		}
		public List<TerminalNode> MINUS_OP() { return getTokens(ScriptParser.MINUS_OP); }
		public TerminalNode MINUS_OP(int i) {
			return getToken(ScriptParser.MINUS_OP, i);
		}
		public SumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sum; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitSum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SumContext sum() throws RecognitionException {
		SumContext _localctx = new SumContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sum);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			multiplication();
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS_OP || _la==MINUS_OP) {
				{
				{
				setState(161);
				_la = _input.LA(1);
				if ( !(_la==PLUS_OP || _la==MINUS_OP) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(162);
				multiplication();
				}
				}
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicationContext extends ParserRuleContext {
		public List<SingleOperationContext> singleOperation() {
			return getRuleContexts(SingleOperationContext.class);
		}
		public SingleOperationContext singleOperation(int i) {
			return getRuleContext(SingleOperationContext.class,i);
		}
		public List<TerminalNode> MULTIPLICATION_OP() { return getTokens(ScriptParser.MULTIPLICATION_OP); }
		public TerminalNode MULTIPLICATION_OP(int i) {
			return getToken(ScriptParser.MULTIPLICATION_OP, i);
		}
		public List<TerminalNode> DIVISION_OP() { return getTokens(ScriptParser.DIVISION_OP); }
		public TerminalNode DIVISION_OP(int i) {
			return getToken(ScriptParser.DIVISION_OP, i);
		}
		public MultiplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplication; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicationContext multiplication() throws RecognitionException {
		MultiplicationContext _localctx = new MultiplicationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_multiplication);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			singleOperation();
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULTIPLICATION_OP || _la==DIVISION_OP) {
				{
				{
				setState(169);
				_la = _input.LA(1);
				if ( !(_la==MULTIPLICATION_OP || _la==DIVISION_OP) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(170);
				singleOperation();
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleOperationContext extends ParserRuleContext {
		public NumericOperationContext numericOperation() {
			return getRuleContext(NumericOperationContext.class,0);
		}
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public IdAtomContext idAtom() {
			return getRuleContext(IdAtomContext.class,0);
		}
		public IntegerAtomContext integerAtom() {
			return getRuleContext(IntegerAtomContext.class,0);
		}
		public TextAtomContext textAtom() {
			return getRuleContext(TextAtomContext.class,0);
		}
		public TerminalNode MINUS_OP() { return getToken(ScriptParser.MINUS_OP, 0); }
		public SingleOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleOperation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitSingleOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleOperationContext singleOperation() throws RecognitionException {
		SingleOperationContext _localctx = new SingleOperationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_singleOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS_OP) {
				{
				setState(176);
				match(MINUS_OP);
				}
			}

			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(179);
				numericOperation();
				}
				break;
			case 2:
				{
				setState(180);
				functionInvocation();
				}
				break;
			case 3:
				{
				setState(181);
				idAtom();
				}
				break;
			case 4:
				{
				setState(182);
				integerAtom();
				}
				break;
			case 5:
				{
				setState(183);
				textAtom();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode OPEN_ROUND_BRACKETS() { return getToken(ScriptParser.OPEN_ROUND_BRACKETS, 0); }
		public AlternativeContext alternative() {
			return getRuleContext(AlternativeContext.class,0);
		}
		public TerminalNode CLOSE_ROUND_BRACKETS() { return getToken(ScriptParser.CLOSE_ROUND_BRACKETS, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(OPEN_ROUND_BRACKETS);
			setState(187);
			alternative();
			setState(188);
			match(CLOSE_ROUND_BRACKETS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlternativeContext extends ParserRuleContext {
		public List<CojunctionContext> cojunction() {
			return getRuleContexts(CojunctionContext.class);
		}
		public CojunctionContext cojunction(int i) {
			return getRuleContext(CojunctionContext.class,i);
		}
		public List<TerminalNode> OR_OP() { return getTokens(ScriptParser.OR_OP); }
		public TerminalNode OR_OP(int i) {
			return getToken(ScriptParser.OR_OP, i);
		}
		public AlternativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alternative; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitAlternative(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlternativeContext alternative() throws RecognitionException {
		AlternativeContext _localctx = new AlternativeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_alternative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			cojunction();
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR_OP) {
				{
				{
				setState(191);
				match(OR_OP);
				setState(192);
				cojunction();
				}
				}
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CojunctionContext extends ParserRuleContext {
		public List<CojunctionOperandContext> cojunctionOperand() {
			return getRuleContexts(CojunctionOperandContext.class);
		}
		public CojunctionOperandContext cojunctionOperand(int i) {
			return getRuleContext(CojunctionOperandContext.class,i);
		}
		public List<TerminalNode> AND_OP() { return getTokens(ScriptParser.AND_OP); }
		public TerminalNode AND_OP(int i) {
			return getToken(ScriptParser.AND_OP, i);
		}
		public CojunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cojunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitCojunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CojunctionContext cojunction() throws RecognitionException {
		CojunctionContext _localctx = new CojunctionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_cojunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			cojunctionOperand();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND_OP) {
				{
				{
				setState(199);
				match(AND_OP);
				setState(200);
				cojunctionOperand();
				}
				}
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CojunctionOperandContext extends ParserRuleContext {
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public SingleConditionContext singleCondition() {
			return getRuleContext(SingleConditionContext.class,0);
		}
		public CojunctionOperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cojunctionOperand; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitCojunctionOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CojunctionOperandContext cojunctionOperand() throws RecognitionException {
		CojunctionOperandContext _localctx = new CojunctionOperandContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_cojunctionOperand);
		try {
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				comparison();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				singleCondition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonContext extends ParserRuleContext {
		public TerminalNode COMPARISON_OP() { return getToken(ScriptParser.COMPARISON_OP, 0); }
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public List<FunctionInvocationContext> functionInvocation() {
			return getRuleContexts(FunctionInvocationContext.class);
		}
		public FunctionInvocationContext functionInvocation(int i) {
			return getRuleContext(FunctionInvocationContext.class,i);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<SumContext> sum() {
			return getRuleContexts(SumContext.class);
		}
		public SumContext sum(int i) {
			return getRuleContext(SumContext.class,i);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_comparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(210);
				atom();
				}
				break;
			case 2:
				{
				setState(211);
				functionInvocation();
				}
				break;
			case 3:
				{
				setState(212);
				condition();
				}
				break;
			case 4:
				{
				setState(213);
				sum();
				}
				break;
			}
			setState(216);
			match(COMPARISON_OP);
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(217);
				atom();
				}
				break;
			case 2:
				{
				setState(218);
				functionInvocation();
				}
				break;
			case 3:
				{
				setState(219);
				condition();
				}
				break;
			case 4:
				{
				setState(220);
				sum();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleConditionContext extends ParserRuleContext {
		public BooleanAtomContext booleanAtom() {
			return getRuleContext(BooleanAtomContext.class,0);
		}
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public IdAtomContext idAtom() {
			return getRuleContext(IdAtomContext.class,0);
		}
		public TerminalNode NEGATION_OP() { return getToken(ScriptParser.NEGATION_OP, 0); }
		public SingleConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitSingleCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleConditionContext singleCondition() throws RecognitionException {
		SingleConditionContext _localctx = new SingleConditionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_singleCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEGATION_OP) {
				{
				setState(223);
				match(NEGATION_OP);
				}
			}

			setState(230);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(226);
				booleanAtom();
				}
				break;
			case 2:
				{
				setState(227);
				functionInvocation();
				}
				break;
			case 3:
				{
				setState(228);
				condition();
				}
				break;
			case 4:
				{
				setState(229);
				idAtom();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public AlternativeContext alternative() {
			return getRuleContext(AlternativeContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_value);
		try {
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				atom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				functionInvocation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(234);
				sum();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(235);
				alternative();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public IntegerAtomContext integerAtom() {
			return getRuleContext(IntegerAtomContext.class,0);
		}
		public BooleanAtomContext booleanAtom() {
			return getRuleContext(BooleanAtomContext.class,0);
		}
		public IdAtomContext idAtom() {
			return getRuleContext(IdAtomContext.class,0);
		}
		public TextAtomContext textAtom() {
			return getRuleContext(TextAtomContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_atom);
		try {
			setState(242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER_VARIABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				integerAtom();
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				booleanAtom();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(240);
				idAtom();
				}
				break;
			case TEXT_VARIABLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(241);
				textAtom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerAtomContext extends ParserRuleContext {
		public TerminalNode INTEGER_VARIABLE() { return getToken(ScriptParser.INTEGER_VARIABLE, 0); }
		public IntegerAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerAtom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitIntegerAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerAtomContext integerAtom() throws RecognitionException {
		IntegerAtomContext _localctx = new IntegerAtomContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_integerAtom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(INTEGER_VARIABLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanAtomContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(ScriptParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ScriptParser.FALSE, 0); }
		public BooleanAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanAtom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitBooleanAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanAtomContext booleanAtom() throws RecognitionException {
		BooleanAtomContext _localctx = new BooleanAtomContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_booleanAtom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TextAtomContext extends ParserRuleContext {
		public TerminalNode TEXT_VARIABLE() { return getToken(ScriptParser.TEXT_VARIABLE, 0); }
		public TextAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textAtom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitTextAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextAtomContext textAtom() throws RecognitionException {
		TextAtomContext _localctx = new TextAtomContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_textAtom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(TEXT_VARIABLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdAtomContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ScriptParser.ID, 0); }
		public IdAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idAtom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitIdAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdAtomContext idAtom() throws RecognitionException {
		IdAtomContext _localctx = new IdAtomContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_idAtom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u00ff\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\7\2<\n\2\f\2\16\2?\13\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4L\n\4\f\4\16\4O\13\4\5\4"+
		"Q\n\4\3\4\3\4\3\5\3\5\7\5W\n\5\f\5\16\5Z\13\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6l\n\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\7\7u\n\7\f\7\16\7x\13\7\3\7\3\7\5\7|\n\7\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\5\n\u0089\n\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\7\r\u0096\n\r\f\r\16\r\u0099\13\r\5\r\u009b\n\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\7\17\u00a6\n\17\f\17\16\17\u00a9"+
		"\13\17\3\20\3\20\3\20\7\20\u00ae\n\20\f\20\16\20\u00b1\13\20\3\21\5\21"+
		"\u00b4\n\21\3\21\3\21\3\21\3\21\3\21\5\21\u00bb\n\21\3\22\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\7\23\u00c4\n\23\f\23\16\23\u00c7\13\23\3\24\3\24\3"+
		"\24\7\24\u00cc\n\24\f\24\16\24\u00cf\13\24\3\25\3\25\5\25\u00d3\n\25\3"+
		"\26\3\26\3\26\3\26\5\26\u00d9\n\26\3\26\3\26\3\26\3\26\3\26\5\26\u00e0"+
		"\n\26\3\27\5\27\u00e3\n\27\3\27\3\27\3\27\3\27\5\27\u00e9\n\27\3\30\3"+
		"\30\3\30\3\30\5\30\u00ef\n\30\3\31\3\31\3\31\3\31\5\31\u00f5\n\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\2\2\36\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668\2\5\3\2\25\26\3\2\27\30\3\2\32\33"+
		"\2\u010a\2=\3\2\2\2\4@\3\2\2\2\6E\3\2\2\2\bT\3\2\2\2\nk\3\2\2\2\fm\3\2"+
		"\2\2\16}\3\2\2\2\20\u0081\3\2\2\2\22\u0084\3\2\2\2\24\u008a\3\2\2\2\26"+
		"\u008e\3\2\2\2\30\u0091\3\2\2\2\32\u009e\3\2\2\2\34\u00a2\3\2\2\2\36\u00aa"+
		"\3\2\2\2 \u00b3\3\2\2\2\"\u00bc\3\2\2\2$\u00c0\3\2\2\2&\u00c8\3\2\2\2"+
		"(\u00d2\3\2\2\2*\u00d8\3\2\2\2,\u00e2\3\2\2\2.\u00ee\3\2\2\2\60\u00f4"+
		"\3\2\2\2\62\u00f6\3\2\2\2\64\u00f8\3\2\2\2\66\u00fa\3\2\2\28\u00fc\3\2"+
		"\2\2:<\5\4\3\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\3\3\2\2\2?=\3"+
		"\2\2\2@A\7\3\2\2AB\7\34\2\2BC\5\6\4\2CD\5\b\5\2D\5\3\2\2\2EP\7\4\2\2F"+
		"G\7\3\2\2GM\7\34\2\2HI\7\37\2\2IJ\7\3\2\2JL\7\34\2\2KH\3\2\2\2LO\3\2\2"+
		"\2MK\3\2\2\2MN\3\2\2\2NQ\3\2\2\2OM\3\2\2\2PF\3\2\2\2PQ\3\2\2\2QR\3\2\2"+
		"\2RS\7\5\2\2S\7\3\2\2\2TX\7\6\2\2UW\5\n\6\2VU\3\2\2\2WZ\3\2\2\2XV\3\2"+
		"\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2[\\\7\7\2\2\\\t\3\2\2\2]l\5\f\7\2^l"+
		"\5\16\b\2_`\5\20\t\2`a\7\b\2\2al\3\2\2\2bc\5\22\n\2cd\7\b\2\2dl\3\2\2"+
		"\2ef\5\24\13\2fg\7\b\2\2gl\3\2\2\2hi\5\26\f\2ij\7\b\2\2jl\3\2\2\2k]\3"+
		"\2\2\2k^\3\2\2\2k_\3\2\2\2kb\3\2\2\2ke\3\2\2\2kh\3\2\2\2l\13\3\2\2\2m"+
		"n\7\t\2\2no\5\"\22\2o{\5\b\5\2pq\7\13\2\2qr\5\"\22\2rs\5\b\5\2su\3\2\2"+
		"\2tp\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2yz\7\n\2"+
		"\2z|\5\b\5\2{v\3\2\2\2{|\3\2\2\2|\r\3\2\2\2}~\7\f\2\2~\177\5\"\22\2\177"+
		"\u0080\5\b\5\2\u0080\17\3\2\2\2\u0081\u0082\7\17\2\2\u0082\u0083\5.\30"+
		"\2\u0083\21\3\2\2\2\u0084\u0085\7\3\2\2\u0085\u0088\7\34\2\2\u0086\u0087"+
		"\7\20\2\2\u0087\u0089\5.\30\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2"+
		"\u0089\23\3\2\2\2\u008a\u008b\7\34\2\2\u008b\u008c\7\20\2\2\u008c\u008d"+
		"\5.\30\2\u008d\25\3\2\2\2\u008e\u008f\7\34\2\2\u008f\u0090\5\30\r\2\u0090"+
		"\27\3\2\2\2\u0091\u009a\7\4\2\2\u0092\u0097\5.\30\2\u0093\u0094\7\37\2"+
		"\2\u0094\u0096\5.\30\2\u0095\u0093\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095"+
		"\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u009a"+
		"\u0092\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\7\5"+
		"\2\2\u009d\31\3\2\2\2\u009e\u009f\7\4\2\2\u009f\u00a0\5\34\17\2\u00a0"+
		"\u00a1\7\5\2\2\u00a1\33\3\2\2\2\u00a2\u00a7\5\36\20\2\u00a3\u00a4\t\2"+
		"\2\2\u00a4\u00a6\5\36\20\2\u00a5\u00a3\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\35\3\2\2\2\u00a9\u00a7\3\2\2"+
		"\2\u00aa\u00af\5 \21\2\u00ab\u00ac\t\3\2\2\u00ac\u00ae\5 \21\2\u00ad\u00ab"+
		"\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\37\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b4\7\26\2\2\u00b3\u00b2\3\2\2"+
		"\2\u00b3\u00b4\3\2\2\2\u00b4\u00ba\3\2\2\2\u00b5\u00bb\5\32\16\2\u00b6"+
		"\u00bb\5\26\f\2\u00b7\u00bb\58\35\2\u00b8\u00bb\5\62\32\2\u00b9\u00bb"+
		"\5\66\34\2\u00ba\u00b5\3\2\2\2\u00ba\u00b6\3\2\2\2\u00ba\u00b7\3\2\2\2"+
		"\u00ba\u00b8\3\2\2\2\u00ba\u00b9\3\2\2\2\u00bb!\3\2\2\2\u00bc\u00bd\7"+
		"\4\2\2\u00bd\u00be\5$\23\2\u00be\u00bf\7\5\2\2\u00bf#\3\2\2\2\u00c0\u00c5"+
		"\5&\24\2\u00c1\u00c2\7\21\2\2\u00c2\u00c4\5&\24\2\u00c3\u00c1\3\2\2\2"+
		"\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6%\3"+
		"\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00cd\5(\25\2\u00c9\u00ca\7\22\2\2\u00ca"+
		"\u00cc\5(\25\2\u00cb\u00c9\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2"+
		"\2\2\u00cd\u00ce\3\2\2\2\u00ce\'\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d3"+
		"\5*\26\2\u00d1\u00d3\5,\27\2\u00d2\u00d0\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3"+
		")\3\2\2\2\u00d4\u00d9\5\60\31\2\u00d5\u00d9\5\26\f\2\u00d6\u00d9\5\"\22"+
		"\2\u00d7\u00d9\5\34\17\2\u00d8\u00d4\3\2\2\2\u00d8\u00d5\3\2\2\2\u00d8"+
		"\u00d6\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00df\7\23"+
		"\2\2\u00db\u00e0\5\60\31\2\u00dc\u00e0\5\26\f\2\u00dd\u00e0\5\"\22\2\u00de"+
		"\u00e0\5\34\17\2\u00df\u00db\3\2\2\2\u00df\u00dc\3\2\2\2\u00df\u00dd\3"+
		"\2\2\2\u00df\u00de\3\2\2\2\u00e0+\3\2\2\2\u00e1\u00e3\7\24\2\2\u00e2\u00e1"+
		"\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e8\3\2\2\2\u00e4\u00e9\5\64\33\2"+
		"\u00e5\u00e9\5\26\f\2\u00e6\u00e9\5\"\22\2\u00e7\u00e9\58\35\2\u00e8\u00e4"+
		"\3\2\2\2\u00e8\u00e5\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9"+
		"-\3\2\2\2\u00ea\u00ef\5\60\31\2\u00eb\u00ef\5\26\f\2\u00ec\u00ef\5\34"+
		"\17\2\u00ed\u00ef\5$\23\2\u00ee\u00ea\3\2\2\2\u00ee\u00eb\3\2\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ef/\3\2\2\2\u00f0\u00f5\5\62\32"+
		"\2\u00f1\u00f5\5\64\33\2\u00f2\u00f5\58\35\2\u00f3\u00f5\5\66\34\2\u00f4"+
		"\u00f0\3\2\2\2\u00f4\u00f1\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f3\3\2"+
		"\2\2\u00f5\61\3\2\2\2\u00f6\u00f7\7\35\2\2\u00f7\63\3\2\2\2\u00f8\u00f9"+
		"\t\4\2\2\u00f9\65\3\2\2\2\u00fa\u00fb\7\36\2\2\u00fb\67\3\2\2\2\u00fc"+
		"\u00fd\7\34\2\2\u00fd9\3\2\2\2\31=MPXkv{\u0088\u0097\u009a\u00a7\u00af"+
		"\u00b3\u00ba\u00c5\u00cd\u00d2\u00d8\u00df\u00e2\u00e8\u00ee\u00f4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}