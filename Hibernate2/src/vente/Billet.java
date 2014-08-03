package vente;

import vente.base.BaseBillet;

/**
 * This is the object class that relates to the billet table.
 * Any customizations belong here.
 */
public class Billet extends BaseBillet {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Billet () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Billet (java.lang.Integer _idbillet) {
		super(_idbillet);
	}

	/**
	 * Constructor for required fields
	 */
	public Billet (
		java.lang.Integer _idbillet,
		java.lang.String _contenu,
		java.util.Date _date,
		java.lang.String _titre) {

		super (
			_idbillet,
			_contenu,
			_date,
			_titre);
	}

/*[CONSTRUCTOR MARKER END]*/
}