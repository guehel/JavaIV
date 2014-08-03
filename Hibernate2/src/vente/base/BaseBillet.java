package vente.base;

import java.io.Serializable;


/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an object that contains data related to the billet table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="billet"
 */
public abstract class BaseBillet  implements Serializable {

	public static String PROP_DATE = "Date";
	public static String PROP_IDBILLET = "Idbillet";
	public static String PROP_TITRE = "Titre";
	public static String PROP_CONTENU = "Contenu";


	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer _idbillet;

	// fields
	private java.lang.String _contenu;
	private java.util.Date _date;
	private java.lang.String _titre;

	// collections
	private java.util.Set _commentaireSet;


	// constructors
	public BaseBillet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBillet (java.lang.Integer _idbillet) {
		this.setIdbillet(_idbillet);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBillet (
		java.lang.Integer _idbillet,
		java.lang.String _contenu,
		java.util.Date _date,
		java.lang.String _titre) {

		this.setIdbillet(_idbillet);
		this.setContenu(_contenu);
		this.setDate(_date);
		this.setTitre(_titre);
		initialize();
	}

	protected void initialize () {}



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="vm"
     *  column="idbillet"
     */
	public java.lang.Integer getIdbillet () {
		return _idbillet;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _idbillet the new ID
	 */
	public void setIdbillet (java.lang.Integer _idbillet) {
		this._idbillet = _idbillet;
		this.hashCode = Integer.MIN_VALUE;
	}


	/**
	 * Return the value associated with the column: contenu
	 */
	public java.lang.String getContenu () {
		return _contenu;
	}

	/**
	 * Set the value related to the column: contenu
	 * @param _contenu the contenu value
	 */
	public void setContenu (java.lang.String _contenu) {
		this._contenu = _contenu;
	}


	/**
	 * Return the value associated with the column: date
	 */
	public java.util.Date getDate () {
		return _date;
	}

	/**
	 * Set the value related to the column: date
	 * @param _date the date value
	 */
	public void setDate (java.util.Date _date) {
		this._date = _date;
	}


	/**
	 * Return the value associated with the column: titre
	 */
	public java.lang.String getTitre () {
		return _titre;
	}

	/**
	 * Set the value related to the column: titre
	 * @param _titre the titre value
	 */
	public void setTitre (java.lang.String _titre) {
		this._titre = _titre;
	}


	/**
	 * Return the value associated with the column: CommentaireSet
	 */
	public java.util.Set getCommentaireSet () {
		return this._commentaireSet;
	}

	/**
	 * Set the value related to the column: CommentaireSet
	 * @param _commentaireSet the CommentaireSet value
	 */
	public void setCommentaireSet (java.util.Set _commentaireSet) {
		this._commentaireSet = _commentaireSet;
	}
	
	public void addToCommentaireSet (Object obj) {
		if (null == this._commentaireSet) this._commentaireSet = new java.util.HashSet();
		this._commentaireSet.add(obj);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof vente.base.BaseBillet)) return false;
		else {
			vente.base.BaseBillet mObj = (vente.base.BaseBillet) obj;
			if (null == this.getIdbillet() || null == mObj.getIdbillet()) return false;
			else return (this.getIdbillet().equals(mObj.getIdbillet()));
		}
	}


	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getIdbillet()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getIdbillet().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}

}