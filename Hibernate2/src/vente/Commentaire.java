package vente;

import vente.base.BaseCommentaire;

/**
 * This is the object class that relates to the commentaire table.
 * Any customizations belong here.
 */
public class Commentaire extends BaseCommentaire {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Commentaire () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Commentaire (vente.CommentairePK _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public Commentaire (
		vente.CommentairePK _id,
		java.lang.String _auteurCom,
		java.lang.String _contenuCom,
		java.util.Date _dateCom) {

		super (
			_id,
			_auteurCom,
			_contenuCom,
			_dateCom);
	}

/*[CONSTRUCTOR MARKER END]*/
}