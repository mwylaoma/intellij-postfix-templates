// This is a generated file. Not intended for manual editing.
package de.endrullis.idea.postfixtemplates.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static de.endrullis.idea.postfixtemplates.language.psi.CptTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class CptParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == MAPPING) {
      r = mapping(b, 0);
    }
    else if (t == MAPPINGS) {
      r = mappings(b, 0);
    }
    else if (t == REPLACEMENT) {
      r = replacement(b, 0);
    }
    else if (t == TEMPLATE) {
      r = template(b, 0);
    }
    else if (t == TEMPLATE_CODE) {
      r = templateCode(b, 0);
    }
    else if (t == TEMPLATE_VARIABLE) {
      r = templateVariable(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return CptFile(b, l + 1);
  }

  /* ********************************************************** */
  // (template|COMMENT)*
  static boolean CptFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CptFile")) return false;
    int c = current_position_(b);
    while (true) {
      if (!CptFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "CptFile", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // template|COMMENT
  private static boolean CptFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CptFile_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = template(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CLASS_NAME MAP replacement
  public static boolean mapping(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapping")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MAPPING, "<mapping>");
    r = consumeTokens(b, 0, CLASS_NAME, MAP);
    r = r && replacement(b, l + 1);
    exit_section_(b, l, m, r, false, recover_parser_parser_);
    return r;
  }

  /* ********************************************************** */
  // mapping*
  public static boolean mappings(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mappings")) return false;
    Marker m = enter_section_(b, l, _NONE_, MAPPINGS, "<mappings>");
    int c = current_position_(b);
    while (true) {
      if (!mapping(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mappings", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // !(TEMPLATE_NAME|CLASS_NAME|COMMENT)
  static boolean recover_parser(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_parser")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !recover_parser_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TEMPLATE_NAME|CLASS_NAME|COMMENT
  private static boolean recover_parser_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_parser_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TEMPLATE_NAME);
    if (!r) r = consumeToken(b, CLASS_NAME);
    if (!r) r = consumeToken(b, COMMENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (templateCode|TEMPLATE_ESCAPE|templateVariable)+
  public static boolean replacement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "replacement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REPLACEMENT, "<replacement>");
    r = replacement_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!replacement_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "replacement", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // templateCode|TEMPLATE_ESCAPE|templateVariable
  private static boolean replacement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "replacement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = templateCode(b, l + 1);
    if (!r) r = consumeToken(b, TEMPLATE_ESCAPE);
    if (!r) r = templateVariable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (TEMPLATE_NAME SEPARATOR TEMPLATE_DESCRIPTION) mappings
  public static boolean template(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEMPLATE, "<template>");
    r = template_0(b, l + 1);
    r = r && mappings(b, l + 1);
    exit_section_(b, l, m, r, false, recover_parser_parser_);
    return r;
  }

  // TEMPLATE_NAME SEPARATOR TEMPLATE_DESCRIPTION
  private static boolean template_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TEMPLATE_NAME, SEPARATOR, TEMPLATE_DESCRIPTION);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TEMPLATE_CODE
  public static boolean templateCode(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "templateCode")) return false;
    if (!nextTokenIs(b, TEMPLATE_CODE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TEMPLATE_CODE);
    exit_section_(b, m, TEMPLATE_CODE, r);
    return r;
  }

  /* ********************************************************** */
  // TEMPLATE_VARIABLE_START TEMPLATE_VARIABLE_NAME
  // 										(TEMPLATE_VARIABLE_SEPARATOR TEMPLATE_VARIABLE_EXPRESSION?
  // 										(TEMPLATE_VARIABLE_SEPARATOR TEMPLATE_VARIABLE_VALUE)?)? TEMPLATE_VARIABLE_END
  public static boolean templateVariable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "templateVariable")) return false;
    if (!nextTokenIs(b, TEMPLATE_VARIABLE_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TEMPLATE_VARIABLE_START, TEMPLATE_VARIABLE_NAME);
    r = r && templateVariable_2(b, l + 1);
    r = r && consumeToken(b, TEMPLATE_VARIABLE_END);
    exit_section_(b, m, TEMPLATE_VARIABLE, r);
    return r;
  }

  // (TEMPLATE_VARIABLE_SEPARATOR TEMPLATE_VARIABLE_EXPRESSION?
  // 										(TEMPLATE_VARIABLE_SEPARATOR TEMPLATE_VARIABLE_VALUE)?)?
  private static boolean templateVariable_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "templateVariable_2")) return false;
    templateVariable_2_0(b, l + 1);
    return true;
  }

  // TEMPLATE_VARIABLE_SEPARATOR TEMPLATE_VARIABLE_EXPRESSION?
  // 										(TEMPLATE_VARIABLE_SEPARATOR TEMPLATE_VARIABLE_VALUE)?
  private static boolean templateVariable_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "templateVariable_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TEMPLATE_VARIABLE_SEPARATOR);
    r = r && templateVariable_2_0_1(b, l + 1);
    r = r && templateVariable_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TEMPLATE_VARIABLE_EXPRESSION?
  private static boolean templateVariable_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "templateVariable_2_0_1")) return false;
    consumeToken(b, TEMPLATE_VARIABLE_EXPRESSION);
    return true;
  }

  // (TEMPLATE_VARIABLE_SEPARATOR TEMPLATE_VARIABLE_VALUE)?
  private static boolean templateVariable_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "templateVariable_2_0_2")) return false;
    templateVariable_2_0_2_0(b, l + 1);
    return true;
  }

  // TEMPLATE_VARIABLE_SEPARATOR TEMPLATE_VARIABLE_VALUE
  private static boolean templateVariable_2_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "templateVariable_2_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TEMPLATE_VARIABLE_SEPARATOR, TEMPLATE_VARIABLE_VALUE);
    exit_section_(b, m, null, r);
    return r;
  }

  final static Parser recover_parser_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return recover_parser(b, l + 1);
    }
  };
}
