package Modele;

import Modele.base.BaseTContact;

/**
 * This is the object class that relates to the t_contact table.
 * Any customizations belong here.
 */
public class TContact extends BaseTContact {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TContact () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TContact (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TContact (
		java.lang.Integer _id,
		java.lang.String _prenom,
		java.lang.Integer _age,
		java.lang.String _nom) {

		super (
			_id,
			_prenom,
			_age,
			_nom);
	}
/*[CONSTRUCTOR MARKER END]*/
}