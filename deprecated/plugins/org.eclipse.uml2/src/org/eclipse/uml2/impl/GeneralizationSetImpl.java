/*
 * Copyright (c) 2003, 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: GeneralizationSetImpl.java,v 1.21 2006/04/10 20:40:18 khussey Exp $
 */
package org.eclipse.uml2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.Classifier;
import org.eclipse.uml2.Generalization;
import org.eclipse.uml2.GeneralizationSet;
import org.eclipse.uml2.StringExpression;
import org.eclipse.uml2.TemplateParameter;
import org.eclipse.uml2.TemplateSignature;
import org.eclipse.uml2.UML2Package;
import org.eclipse.uml2.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generalization Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.impl.GeneralizationSetImpl#isCovering <em>Is Covering</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.GeneralizationSetImpl#isDisjoint <em>Is Disjoint</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.GeneralizationSetImpl#getPowertype <em>Powertype</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.GeneralizationSetImpl#getGeneralizations <em>Generalization</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeneralizationSetImpl extends PackageableElementImpl implements GeneralizationSet {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) IBM Corporation and others."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #isCovering() <em>Is Covering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCovering()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_COVERING_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isCovering() <em>Is Covering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCovering()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_COVERING_EFLAG = 1 << 8;

	/**
	 * The default value of the '{@link #isDisjoint() <em>Is Disjoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisjoint()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DISJOINT_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isDisjoint() <em>Is Disjoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisjoint()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_DISJOINT_EFLAG = 1 << 9;

	/**
	 * The cached value of the '{@link #getPowertype() <em>Powertype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPowertype()
	 * @generated
	 * @ordered
	 */
	protected Classifier powertype = null;

	/**
	 * The cached value of the '{@link #getGeneralizations() <em>Generalization</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralizations()
	 * @generated
	 * @ordered
	 */
	protected EList generalizations = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneralizationSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UML2Package.Literals.GENERALIZATION_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCovering() {
		return (eFlags & IS_COVERING_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsCovering(boolean newIsCovering) {
		boolean oldIsCovering = (eFlags & IS_COVERING_EFLAG) != 0;
		if (newIsCovering) eFlags |= IS_COVERING_EFLAG; else eFlags &= ~IS_COVERING_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2Package.GENERALIZATION_SET__IS_COVERING, oldIsCovering, newIsCovering));


	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDisjoint() {
		return (eFlags & IS_DISJOINT_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDisjoint(boolean newIsDisjoint) {
		boolean oldIsDisjoint = (eFlags & IS_DISJOINT_EFLAG) != 0;
		if (newIsDisjoint) eFlags |= IS_DISJOINT_EFLAG; else eFlags &= ~IS_DISJOINT_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2Package.GENERALIZATION_SET__IS_DISJOINT, oldIsDisjoint, newIsDisjoint));


	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier getPowertype() {
		if (powertype != null && powertype.eIsProxy()) {
			InternalEObject oldPowertype = (InternalEObject)powertype;
			powertype = (Classifier)eResolveProxy(oldPowertype);
			if (powertype != oldPowertype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UML2Package.GENERALIZATION_SET__POWERTYPE, oldPowertype, powertype));
			}
		}
		return powertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier basicGetPowertype() {
		return powertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPowertype(Classifier newPowertype, NotificationChain msgs) {
		Classifier oldPowertype = powertype;
		powertype = newPowertype;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UML2Package.GENERALIZATION_SET__POWERTYPE, oldPowertype, newPowertype);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}

		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPowertype(Classifier newPowertype) {
		if (newPowertype != powertype) {
			NotificationChain msgs = null;
			if (powertype != null)
				msgs = ((InternalEObject)powertype).eInverseRemove(this, UML2Package.CLASSIFIER__POWERTYPE_EXTENT, Classifier.class, msgs);
			if (newPowertype != null)
				msgs = ((InternalEObject)newPowertype).eInverseAdd(this, UML2Package.CLASSIFIER__POWERTYPE_EXTENT, Classifier.class, msgs);
			msgs = basicSetPowertype(newPowertype, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2Package.GENERALIZATION_SET__POWERTYPE, newPowertype, newPowertype));

	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getGeneralizations() {
		if (generalizations == null) {
			generalizations = new EObjectWithInverseResolvingEList.ManyInverse(Generalization.class, this, UML2Package.GENERALIZATION_SET__GENERALIZATION, UML2Package.GENERALIZATION__GENERALIZATION_SET);
		}
		return generalizations;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UML2Package.GENERALIZATION_SET__EANNOTATIONS:
				return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
			case UML2Package.GENERALIZATION_SET__TEMPLATE_BINDING:
				return ((InternalEList)getTemplateBindings()).basicAdd(otherEnd, msgs);
			case UML2Package.GENERALIZATION_SET__OWNED_TEMPLATE_SIGNATURE:
				if (ownedTemplateSignature != null)
					msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UML2Package.GENERALIZATION_SET__OWNED_TEMPLATE_SIGNATURE, null, msgs);
				return basicSetOwnedTemplateSignature((TemplateSignature)otherEnd, msgs);
			case UML2Package.GENERALIZATION_SET__CLIENT_DEPENDENCY:
				return ((InternalEList)getClientDependencies()).basicAdd(otherEnd, msgs);
			case UML2Package.GENERALIZATION_SET__TEMPLATE_PARAMETER:
				if (templateParameter != null)
					msgs = ((InternalEObject)templateParameter).eInverseRemove(this, UML2Package.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
				return basicSetTemplateParameter((TemplateParameter)otherEnd, msgs);
			case UML2Package.GENERALIZATION_SET__OWNING_PARAMETER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningParameter((TemplateParameter)otherEnd, msgs);
			case UML2Package.GENERALIZATION_SET__POWERTYPE:
				if (powertype != null)
					msgs = ((InternalEObject)powertype).eInverseRemove(this, UML2Package.CLASSIFIER__POWERTYPE_EXTENT, Classifier.class, msgs);
				return basicSetPowertype((Classifier)otherEnd, msgs);
			case UML2Package.GENERALIZATION_SET__GENERALIZATION:
				return ((InternalEList)getGeneralizations()).basicAdd(otherEnd, msgs);
		}
		return eDynamicInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UML2Package.GENERALIZATION_SET__EANNOTATIONS:
				return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
			case UML2Package.GENERALIZATION_SET__OWNED_COMMENT:
				return ((InternalEList)getOwnedComments()).basicRemove(otherEnd, msgs);
			case UML2Package.GENERALIZATION_SET__TEMPLATE_BINDING:
				return ((InternalEList)getTemplateBindings()).basicRemove(otherEnd, msgs);
			case UML2Package.GENERALIZATION_SET__OWNED_TEMPLATE_SIGNATURE:
				return basicSetOwnedTemplateSignature(null, msgs);
			case UML2Package.GENERALIZATION_SET__CLIENT_DEPENDENCY:
				return ((InternalEList)getClientDependencies()).basicRemove(otherEnd, msgs);
			case UML2Package.GENERALIZATION_SET__NAME_EXPRESSION:
				return basicSetNameExpression(null, msgs);
			case UML2Package.GENERALIZATION_SET__TEMPLATE_PARAMETER:
				return basicSetTemplateParameter(null, msgs);
			case UML2Package.GENERALIZATION_SET__OWNING_PARAMETER:
				return basicSetOwningParameter(null, msgs);
			case UML2Package.GENERALIZATION_SET__POWERTYPE:
				return basicSetPowertype(null, msgs);
			case UML2Package.GENERALIZATION_SET__GENERALIZATION:
				return ((InternalEList)getGeneralizations()).basicRemove(otherEnd, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UML2Package.GENERALIZATION_SET__EANNOTATIONS:
				return getEAnnotations();
			case UML2Package.GENERALIZATION_SET__OWNED_ELEMENT:
				return getOwnedElements();
			case UML2Package.GENERALIZATION_SET__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case UML2Package.GENERALIZATION_SET__OWNED_COMMENT:
				return getOwnedComments();
			case UML2Package.GENERALIZATION_SET__TEMPLATE_BINDING:
				return getTemplateBindings();
			case UML2Package.GENERALIZATION_SET__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case UML2Package.GENERALIZATION_SET__NAME:
				return getName();
			case UML2Package.GENERALIZATION_SET__QUALIFIED_NAME:
				return getQualifiedName();
			case UML2Package.GENERALIZATION_SET__VISIBILITY:
				return getVisibility();
			case UML2Package.GENERALIZATION_SET__CLIENT_DEPENDENCY:
				return getClientDependencies();
			case UML2Package.GENERALIZATION_SET__NAME_EXPRESSION:
				return getNameExpression();
			case UML2Package.GENERALIZATION_SET__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case UML2Package.GENERALIZATION_SET__OWNING_PARAMETER:
				return getOwningParameter();
			case UML2Package.GENERALIZATION_SET__PACKAGEABLE_ELEMENT_VISIBILITY:
				return getPackageableElement_visibility();
			case UML2Package.GENERALIZATION_SET__IS_COVERING:
				return isCovering() ? Boolean.TRUE : Boolean.FALSE;
			case UML2Package.GENERALIZATION_SET__IS_DISJOINT:
				return isDisjoint() ? Boolean.TRUE : Boolean.FALSE;
			case UML2Package.GENERALIZATION_SET__POWERTYPE:
				if (resolve) return getPowertype();
				return basicGetPowertype();
			case UML2Package.GENERALIZATION_SET__GENERALIZATION:
				return getGeneralizations();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UML2Package.GENERALIZATION_SET__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case UML2Package.GENERALIZATION_SET__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection)newValue);
				return;
			case UML2Package.GENERALIZATION_SET__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection)newValue);
				return;
			case UML2Package.GENERALIZATION_SET__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case UML2Package.GENERALIZATION_SET__NAME:
				setName((String)newValue);
				return;
			case UML2Package.GENERALIZATION_SET__VISIBILITY:
				setVisibility((VisibilityKind)newValue);
				return;
			case UML2Package.GENERALIZATION_SET__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection)newValue);
				return;
			case UML2Package.GENERALIZATION_SET__NAME_EXPRESSION:
				setNameExpression((StringExpression)newValue);
				return;
			case UML2Package.GENERALIZATION_SET__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case UML2Package.GENERALIZATION_SET__OWNING_PARAMETER:
				setOwningParameter((TemplateParameter)newValue);
				return;
			case UML2Package.GENERALIZATION_SET__PACKAGEABLE_ELEMENT_VISIBILITY:
				setPackageableElement_visibility((VisibilityKind)newValue);
				return;
			case UML2Package.GENERALIZATION_SET__IS_COVERING:
				setIsCovering(((Boolean)newValue).booleanValue());
				return;
			case UML2Package.GENERALIZATION_SET__IS_DISJOINT:
				setIsDisjoint(((Boolean)newValue).booleanValue());
				return;
			case UML2Package.GENERALIZATION_SET__POWERTYPE:
				setPowertype((Classifier)newValue);
				return;
			case UML2Package.GENERALIZATION_SET__GENERALIZATION:
				getGeneralizations().clear();
				getGeneralizations().addAll((Collection)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case UML2Package.GENERALIZATION_SET__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case UML2Package.GENERALIZATION_SET__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case UML2Package.GENERALIZATION_SET__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				return;
			case UML2Package.GENERALIZATION_SET__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case UML2Package.GENERALIZATION_SET__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UML2Package.GENERALIZATION_SET__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case UML2Package.GENERALIZATION_SET__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				return;
			case UML2Package.GENERALIZATION_SET__NAME_EXPRESSION:
				setNameExpression((StringExpression)null);
				return;
			case UML2Package.GENERALIZATION_SET__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case UML2Package.GENERALIZATION_SET__OWNING_PARAMETER:
				setOwningParameter((TemplateParameter)null);
				return;
			case UML2Package.GENERALIZATION_SET__PACKAGEABLE_ELEMENT_VISIBILITY:
				setPackageableElement_visibility(PACKAGEABLE_ELEMENT_VISIBILITY_EDEFAULT);
				return;
			case UML2Package.GENERALIZATION_SET__IS_COVERING:
				setIsCovering(IS_COVERING_EDEFAULT);
				return;
			case UML2Package.GENERALIZATION_SET__IS_DISJOINT:
				setIsDisjoint(IS_DISJOINT_EDEFAULT);
				return;
			case UML2Package.GENERALIZATION_SET__POWERTYPE:
				setPowertype((Classifier)null);
				return;
			case UML2Package.GENERALIZATION_SET__GENERALIZATION:
				getGeneralizations().clear();
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UML2Package.GENERALIZATION_SET__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UML2Package.GENERALIZATION_SET__OWNED_ELEMENT:
				return isSetOwnedElements();
			case UML2Package.GENERALIZATION_SET__OWNER:
				return isSetOwner();
			case UML2Package.GENERALIZATION_SET__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case UML2Package.GENERALIZATION_SET__TEMPLATE_BINDING:
				return templateBindings != null && !templateBindings.isEmpty();
			case UML2Package.GENERALIZATION_SET__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case UML2Package.GENERALIZATION_SET__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UML2Package.GENERALIZATION_SET__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? getQualifiedName() != null : !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UML2Package.GENERALIZATION_SET__VISIBILITY:
				return isSetVisibility();
			case UML2Package.GENERALIZATION_SET__CLIENT_DEPENDENCY:
				return clientDependencies != null && !clientDependencies.isEmpty();
			case UML2Package.GENERALIZATION_SET__NAME_EXPRESSION:
				return nameExpression != null;
			case UML2Package.GENERALIZATION_SET__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case UML2Package.GENERALIZATION_SET__OWNING_PARAMETER:
				return getOwningParameter() != null;
			case UML2Package.GENERALIZATION_SET__PACKAGEABLE_ELEMENT_VISIBILITY:
				return isSetPackageableElement_visibility();
			case UML2Package.GENERALIZATION_SET__IS_COVERING:
				return ((eFlags & IS_COVERING_EFLAG) != 0) != IS_COVERING_EDEFAULT;
			case UML2Package.GENERALIZATION_SET__IS_DISJOINT:
				return ((eFlags & IS_DISJOINT_EFLAG) != 0) != IS_DISJOINT_EDEFAULT;
			case UML2Package.GENERALIZATION_SET__POWERTYPE:
				return powertype != null;
			case UML2Package.GENERALIZATION_SET__GENERALIZATION:
				return generalizations != null && !generalizations.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isCovering: "); //$NON-NLS-1$
		result.append((eFlags & IS_COVERING_EFLAG) != 0);
		result.append(", isDisjoint: "); //$NON-NLS-1$
		result.append((eFlags & IS_DISJOINT_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}


} //GeneralizationSetImpl
