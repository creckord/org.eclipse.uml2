/*
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: GeneralOrderingImpl.java,v 1.5 2005/11/28 20:26:03 khussey Exp $
 */
package org.eclipse.uml2.uml.internal.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>General Ordering</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.GeneralOrderingImpl#getBefore <em>Before</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.GeneralOrderingImpl#getAfter <em>After</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeneralOrderingImpl
		extends NamedElementImpl
		implements GeneralOrdering {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneralOrderingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UMLPackage.Literals.GENERAL_ORDERING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OccurrenceSpecification getBefore() {
		OccurrenceSpecification before = (OccurrenceSpecification) eVirtualGet(UMLPackage.GENERAL_ORDERING__BEFORE);
		if (before != null && before.eIsProxy()) {
			InternalEObject oldBefore = (InternalEObject) before;
			before = (OccurrenceSpecification) eResolveProxy(oldBefore);
			if (before != oldBefore) {
				eVirtualSet(UMLPackage.GENERAL_ORDERING__BEFORE, before);
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						UMLPackage.GENERAL_ORDERING__BEFORE, oldBefore, before));
			}
		}
		return before;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OccurrenceSpecification basicGetBefore() {
		return (OccurrenceSpecification) eVirtualGet(UMLPackage.GENERAL_ORDERING__BEFORE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBefore(OccurrenceSpecification newBefore,
			NotificationChain msgs) {
		Object oldBefore = eVirtualSet(UMLPackage.GENERAL_ORDERING__BEFORE,
			newBefore);
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET, UMLPackage.GENERAL_ORDERING__BEFORE,
				oldBefore == EVIRTUAL_NO_VALUE
					? null
					: oldBefore, newBefore);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}

		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBefore(OccurrenceSpecification newBefore) {
		OccurrenceSpecification before = (OccurrenceSpecification) eVirtualGet(UMLPackage.GENERAL_ORDERING__BEFORE);
		if (newBefore != before) {
			NotificationChain msgs = null;
			if (before != null)
				msgs = ((InternalEObject) before).eInverseRemove(this,
					UMLPackage.OCCURRENCE_SPECIFICATION__TO_AFTER,
					OccurrenceSpecification.class, msgs);
			if (newBefore != null)
				msgs = ((InternalEObject) newBefore).eInverseAdd(this,
					UMLPackage.OCCURRENCE_SPECIFICATION__TO_AFTER,
					OccurrenceSpecification.class, msgs);
			msgs = basicSetBefore(newBefore, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.GENERAL_ORDERING__BEFORE, newBefore, newBefore));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OccurrenceSpecification getAfter() {
		OccurrenceSpecification after = (OccurrenceSpecification) eVirtualGet(UMLPackage.GENERAL_ORDERING__AFTER);
		if (after != null && after.eIsProxy()) {
			InternalEObject oldAfter = (InternalEObject) after;
			after = (OccurrenceSpecification) eResolveProxy(oldAfter);
			if (after != oldAfter) {
				eVirtualSet(UMLPackage.GENERAL_ORDERING__AFTER, after);
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						UMLPackage.GENERAL_ORDERING__AFTER, oldAfter, after));
			}
		}
		return after;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OccurrenceSpecification basicGetAfter() {
		return (OccurrenceSpecification) eVirtualGet(UMLPackage.GENERAL_ORDERING__AFTER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAfter(OccurrenceSpecification newAfter,
			NotificationChain msgs) {
		Object oldAfter = eVirtualSet(UMLPackage.GENERAL_ORDERING__AFTER,
			newAfter);
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET, UMLPackage.GENERAL_ORDERING__AFTER,
				oldAfter == EVIRTUAL_NO_VALUE
					? null
					: oldAfter, newAfter);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}

		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAfter(OccurrenceSpecification newAfter) {
		OccurrenceSpecification after = (OccurrenceSpecification) eVirtualGet(UMLPackage.GENERAL_ORDERING__AFTER);
		if (newAfter != after) {
			NotificationChain msgs = null;
			if (after != null)
				msgs = ((InternalEObject) after).eInverseRemove(this,
					UMLPackage.OCCURRENCE_SPECIFICATION__TO_BEFORE,
					OccurrenceSpecification.class, msgs);
			if (newAfter != null)
				msgs = ((InternalEObject) newAfter).eInverseAdd(this,
					UMLPackage.OCCURRENCE_SPECIFICATION__TO_BEFORE,
					OccurrenceSpecification.class, msgs);
			msgs = basicSetAfter(newAfter, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.GENERAL_ORDERING__AFTER, newAfter, newAfter));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLPackage.GENERAL_ORDERING__EANNOTATIONS :
				return ((InternalEList) getEAnnotations()).basicAdd(otherEnd,
					msgs);
			case UMLPackage.GENERAL_ORDERING__CLIENT_DEPENDENCY :
				return ((InternalEList) getClientDependencies()).basicAdd(
					otherEnd, msgs);
			case UMLPackage.GENERAL_ORDERING__BEFORE :
				OccurrenceSpecification before = (OccurrenceSpecification) eVirtualGet(UMLPackage.GENERAL_ORDERING__BEFORE);
				if (before != null)
					msgs = ((InternalEObject) before).eInverseRemove(this,
						UMLPackage.OCCURRENCE_SPECIFICATION__TO_AFTER,
						OccurrenceSpecification.class, msgs);
				return basicSetBefore((OccurrenceSpecification) otherEnd, msgs);
			case UMLPackage.GENERAL_ORDERING__AFTER :
				OccurrenceSpecification after = (OccurrenceSpecification) eVirtualGet(UMLPackage.GENERAL_ORDERING__AFTER);
				if (after != null)
					msgs = ((InternalEObject) after).eInverseRemove(this,
						UMLPackage.OCCURRENCE_SPECIFICATION__TO_BEFORE,
						OccurrenceSpecification.class, msgs);
				return basicSetAfter((OccurrenceSpecification) otherEnd, msgs);
		}
		return eDynamicInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLPackage.GENERAL_ORDERING__EANNOTATIONS :
				return ((InternalEList) getEAnnotations()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.GENERAL_ORDERING__OWNED_COMMENT :
				return ((InternalEList) getOwnedComments()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.GENERAL_ORDERING__CLIENT_DEPENDENCY :
				return ((InternalEList) getClientDependencies()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.GENERAL_ORDERING__NAME_EXPRESSION :
				return basicSetNameExpression(null, msgs);
			case UMLPackage.GENERAL_ORDERING__BEFORE :
				return basicSetBefore(null, msgs);
			case UMLPackage.GENERAL_ORDERING__AFTER :
				return basicSetAfter(null, msgs);
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
			case UMLPackage.GENERAL_ORDERING__EANNOTATIONS :
				return getEAnnotations();
			case UMLPackage.GENERAL_ORDERING__OWNED_ELEMENT :
				return getOwnedElements();
			case UMLPackage.GENERAL_ORDERING__OWNER :
				return getOwner();
			case UMLPackage.GENERAL_ORDERING__OWNED_COMMENT :
				return getOwnedComments();
			case UMLPackage.GENERAL_ORDERING__NAME :
				return getName();
			case UMLPackage.GENERAL_ORDERING__VISIBILITY :
				return getVisibility();
			case UMLPackage.GENERAL_ORDERING__QUALIFIED_NAME :
				return getQualifiedName();
			case UMLPackage.GENERAL_ORDERING__CLIENT_DEPENDENCY :
				return getClientDependencies();
			case UMLPackage.GENERAL_ORDERING__NAMESPACE :
				if (resolve)
					return getNamespace();
				return basicGetNamespace();
			case UMLPackage.GENERAL_ORDERING__NAME_EXPRESSION :
				return getNameExpression();
			case UMLPackage.GENERAL_ORDERING__BEFORE :
				if (resolve)
					return getBefore();
				return basicGetBefore();
			case UMLPackage.GENERAL_ORDERING__AFTER :
				if (resolve)
					return getAfter();
				return basicGetAfter();
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
			case UMLPackage.GENERAL_ORDERING__EANNOTATIONS :
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection) newValue);
				return;
			case UMLPackage.GENERAL_ORDERING__OWNED_COMMENT :
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection) newValue);
				return;
			case UMLPackage.GENERAL_ORDERING__NAME :
				setName((String) newValue);
				return;
			case UMLPackage.GENERAL_ORDERING__VISIBILITY :
				setVisibility((VisibilityKind) newValue);
				return;
			case UMLPackage.GENERAL_ORDERING__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection) newValue);
				return;
			case UMLPackage.GENERAL_ORDERING__NAME_EXPRESSION :
				setNameExpression((StringExpression) newValue);
				return;
			case UMLPackage.GENERAL_ORDERING__BEFORE :
				setBefore((OccurrenceSpecification) newValue);
				return;
			case UMLPackage.GENERAL_ORDERING__AFTER :
				setAfter((OccurrenceSpecification) newValue);
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
			case UMLPackage.GENERAL_ORDERING__EANNOTATIONS :
				getEAnnotations().clear();
				return;
			case UMLPackage.GENERAL_ORDERING__OWNED_COMMENT :
				getOwnedComments().clear();
				return;
			case UMLPackage.GENERAL_ORDERING__NAME :
				setName(NAME_EDEFAULT);
				return;
			case UMLPackage.GENERAL_ORDERING__VISIBILITY :
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case UMLPackage.GENERAL_ORDERING__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				return;
			case UMLPackage.GENERAL_ORDERING__NAME_EXPRESSION :
				setNameExpression((StringExpression) null);
				return;
			case UMLPackage.GENERAL_ORDERING__BEFORE :
				setBefore((OccurrenceSpecification) null);
				return;
			case UMLPackage.GENERAL_ORDERING__AFTER :
				setAfter((OccurrenceSpecification) null);
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
			case UMLPackage.GENERAL_ORDERING__EANNOTATIONS :
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UMLPackage.GENERAL_ORDERING__OWNED_ELEMENT :
				return isSetOwnedElements();
			case UMLPackage.GENERAL_ORDERING__OWNER :
				return isSetOwner();
			case UMLPackage.GENERAL_ORDERING__OWNED_COMMENT :
				List ownedComment = (List) eVirtualGet(UMLPackage.GENERAL_ORDERING__OWNED_COMMENT);
				return ownedComment != null && !ownedComment.isEmpty();
			case UMLPackage.GENERAL_ORDERING__NAME :
				String name = (String) eVirtualGet(
					UMLPackage.GENERAL_ORDERING__NAME, NAME_EDEFAULT);
				return NAME_EDEFAULT == null
					? name != null
					: !NAME_EDEFAULT.equals(name);
			case UMLPackage.GENERAL_ORDERING__VISIBILITY :
				return eVirtualGet(UMLPackage.GENERAL_ORDERING__VISIBILITY,
					VISIBILITY_EDEFAULT) != VISIBILITY_EDEFAULT;
			case UMLPackage.GENERAL_ORDERING__QUALIFIED_NAME :
				return QUALIFIED_NAME_EDEFAULT == null
					? getQualifiedName() != null
					: !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UMLPackage.GENERAL_ORDERING__CLIENT_DEPENDENCY :
				List clientDependency = (List) eVirtualGet(UMLPackage.GENERAL_ORDERING__CLIENT_DEPENDENCY);
				return clientDependency != null && !clientDependency.isEmpty();
			case UMLPackage.GENERAL_ORDERING__NAMESPACE :
				return isSetNamespace();
			case UMLPackage.GENERAL_ORDERING__NAME_EXPRESSION :
				return eVirtualGet(UMLPackage.GENERAL_ORDERING__NAME_EXPRESSION) != null;
			case UMLPackage.GENERAL_ORDERING__BEFORE :
				return eVirtualGet(UMLPackage.GENERAL_ORDERING__BEFORE) != null;
			case UMLPackage.GENERAL_ORDERING__AFTER :
				return eVirtualGet(UMLPackage.GENERAL_ORDERING__AFTER) != null;
		}
		return eDynamicIsSet(featureID);
	}

} //GeneralOrderingImpl