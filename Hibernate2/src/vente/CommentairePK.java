package vente;

import vente.base.BaseCommentairePK;

public class CommentairePK extends BaseCommentairePK {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CommentairePK () {}
	
	public CommentairePK (
		java.lang.Integer _idCom,
		vente.Billet _billetIdbillet) {

		super (
		_idCom,
		_billetIdbillet);
	}
/*[CONSTRUCTOR MARKER END]*/
}