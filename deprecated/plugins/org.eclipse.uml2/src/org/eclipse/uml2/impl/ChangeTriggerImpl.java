/*
 * Copyright (c) 2003, 2004 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * $Id: ChangeTriggerImpl.java,v 1.4 2004/05/20 03:20:02 khussey Exp $
 */
package org.eclipse.uml2.impl;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.ChangeTrigger;
import org.eclipse.uml2.StringExpression;
import org.eclipse.uml2.TemplateSignature;
import org.eclipse.uml2.UML2Package;
import org.eclipse.uml2.ValueSpecification;

import org.eclipse.uml2.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Change Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.impl.ChangeTriggerImpl#getChangeExpression <em>Change Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChangeTriggerImpl extends TriggerImpl implements ChangeTrigger {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2003, 2004 IBM Corporation and others."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getChangeExpression() <em>Change Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangeExpression()
	 * @generated
	 * @ordered
	 */
	protected ValueSpecification changeExpression = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangeTriggerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UML2Package.eINSTANCE.getChangeTrigger();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSpecification getChangeExpression() {
		return changeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChangeExpression(ValueSpecification newChangeExpression, NotificationChain msgs) {
		ValueSpecification oldChangeExpression = changeExpression;
		changeExpression = newChangeExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UML2Package.CHANGE_TRIGGER__CHANGE_EXPRESSION, oldChangeExpression, newChangeExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangeExpression(ValueSpecification newChangeExpression) {
		if (newChangeExpression != changeExpression) {
			NotificationChain msgs = null;
			if (changeExpression != null)
				msgs = ((InternalEObject)changeExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UML2Package.CHANGE_TRIGGER__CHANGE_EXPRESSION, null, msgs);
			if (newChangeExpression != null)
				msgs = ((InternalEObject)newChangeExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UML2Package.CHANGE_TRIGGER__CHANGE_EXPRESSION, null, msgs);
			msgs = basicSetChangeExpression(newChangeExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2Package.CHANGE_TRIGGER__CHANGE_EXPRESSION, newChangeExpression, newChangeExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSpecification createChangeExpression(EClass eClass) {
		ValueSpecification newChangeExpression = (ValueSpecification) eClass.getEPackage().getEFactoryInstance().create(eClass);
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, 0, UML2Package.CHANGE_TRIGGER__CHANGE_EXPRESSION, null, newChangeExpression));
		}
        setChangeExpression(newChangeExpression);
		return newChangeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getOwnedElements() {
		if (!getCacheAdapter().containsKey(this, UML2Package.eINSTANCE.getElement_OwnedElement())) {
			Set union = new LinkedHashSet();
			union.addAll(super.getOwnedElements());
			if (null != getChangeExpression()) {
				union.add(getChangeExpression());
			}
			getCacheAdapter().put(
				this,
				UML2Package.eINSTANCE.getElement_OwnedElement(),
				new EcoreEList.UnmodifiableEList(this, 
					UML2Package.eINSTANCE.getElement_OwnedElement(),
					union.size(),
					union.toArray()));
		}
		return (EList) getCacheAdapter().get(this, UML2Package.eINSTANCE.getElement_OwnedElement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case UML2Package.CHANGE_TRIGGER__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case UML2Package.CHANGE_TRIGGER__TEMPLATE_BINDING:
					return ((InternalEList)getTemplateBindings()).basicAdd(otherEnd, msgs);
				case UML2Package.CHANGE_TRIGGER__OWNED_TEMPLATE_SIGNATURE:
					if (ownedTemplateSignature != null)
						msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UML2Package.CHANGE_TRIGGER__OWNED_TEMPLATE_SIGNATURE, null, msgs);
					return basicSetOwnedTemplateSignature((TemplateSignature)otherEnd, msgs);
				case UML2Package.CHANGE_TRIGGER__CLIENT_DEPENDENCY:
					return ((InternalEList)getClientDependencies()).basicAdd(otherEnd, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case UML2Package.CHANGE_TRIGGER__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case UML2Package.CHANGE_TRIGGER__OWNED_COMMENT:
					return ((InternalEList)getOwnedComments()).basicRemove(otherEnd, msgs);
				case UML2Package.CHANGE_TRIGGER__TEMPLATE_BINDING:
					return ((InternalEList)getTemplateBindings()).basicRemove(otherEnd, msgs);
				case UML2Package.CHANGE_TRIGGER__OWNED_TEMPLATE_SIGNATURE:
					return basicSetOwnedTemplateSignature(null, msgs);
				case UML2Package.CHANGE_TRIGGER__CLIENT_DEPENDENCY:
					return ((InternalEList)getClientDependencies()).basicRemove(otherEnd, msgs);
				case UML2Package.CHANGE_TRIGGER__NAME_EXPRESSION:
					return basicSetNameExpression(null, msgs);
				case UML2Package.CHANGE_TRIGGER__CHANGE_EXPRESSION:
					return basicSetChangeExpression(null, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case UML2Package.CHANGE_TRIGGER__EANNOTATIONS:
				return getEAnnotations();
			case UML2Package.CHANGE_TRIGGER__OWNED_ELEMENT:
				return getOwnedElements();
			case UML2Package.CHANGE_TRIGGER__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case UML2Package.CHANGE_TRIGGER__OWNED_COMMENT:
				return getOwnedComments();
			case UML2Package.CHANGE_TRIGGER__TEMPLATE_BINDING:
				return getTemplateBindings();
			case UML2Package.CHANGE_TRIGGER__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case UML2Package.CHANGE_TRIGGER__NAME:
				return getName();
			case UML2Package.CHANGE_TRIGGER__QUALIFIED_NAME:
				return getQualifiedName();
			case UML2Package.CHANGE_TRIGGER__VISIBILITY:
				return getVisibility();
			case UML2Package.CHANGE_TRIGGER__CLIENT_DEPENDENCY:
				return getClientDependencies();
			case UML2Package.CHANGE_TRIGGER__NAME_EXPRESSION:
				return getNameExpression();
			case UML2Package.CHANGE_TRIGGER__PORT:
				return getPorts();
			case UML2Package.CHANGE_TRIGGER__CHANGE_EXPRESSION:
				return getChangeExpression();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case UML2Package.CHANGE_TRIGGER__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case UML2Package.CHANGE_TRIGGER__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection)newValue);
				return;
			case UML2Package.CHANGE_TRIGGER__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection)newValue);
				return;
			case UML2Package.CHANGE_TRIGGER__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case UML2Package.CHANGE_TRIGGER__NAME:
				setName((String)newValue);
				return;
			case UML2Package.CHANGE_TRIGGER__VISIBILITY:
				setVisibility((VisibilityKind)newValue);
				return;
			case UML2Package.CHANGE_TRIGGER__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection)newValue);
				return;
			case UML2Package.CHANGE_TRIGGER__NAME_EXPRESSION:
				setNameExpression((StringExpression)newValue);
				return;
			case UML2Package.CHANGE_TRIGGER__PORT:
				getPorts().clear();
				getPorts().addAll((Collection)newValue);
				return;
			case UML2Package.CHANGE_TRIGGER__CHANGE_EXPRESSION:
				setChangeExpression((ValueSpecification)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case UML2Package.CHANGE_TRIGGER__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case UML2Package.CHANGE_TRIGGER__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case UML2Package.CHANGE_TRIGGER__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				return;
			case UML2Package.CHANGE_TRIGGER__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case UML2Package.CHANGE_TRIGGER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UML2Package.CHANGE_TRIGGER__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case UML2Package.CHANGE_TRIGGER__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				return;
			case UML2Package.CHANGE_TRIGGER__NAME_EXPRESSION:
				setNameExpression((StringExpression)null);
				return;
			case UML2Package.CHANGE_TRIGGER__PORT:
				getPorts().clear();
				return;
			case UML2Package.CHANGE_TRIGGER__CHANGE_EXPRESSION:
				setChangeExpression((ValueSpecification)null);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case UML2Package.CHANGE_TRIGGER__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UML2Package.CHANGE_TRIGGER__OWNED_ELEMENT:
				return !getOwnedElements().isEmpty();
			case UML2Package.CHANGE_TRIGGER__OWNER:
				return basicGetOwner() != null;
			case UML2Package.CHANGE_TRIGGER__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case UML2Package.CHANGE_TRIGGER__TEMPLATE_BINDING:
				return templateBinding != null && !templateBinding.isEmpty();
			case UML2Package.CHANGE_TRIGGER__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case UML2Package.CHANGE_TRIGGER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UML2Package.CHANGE_TRIGGER__QUALIFIED_NAME:
				return !"".equals(getQualifiedName()); //$NON-NLS-1$
			case UML2Package.CHANGE_TRIGGER__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case UML2Package.CHANGE_TRIGGER__CLIENT_DEPENDENCY:
				return clientDependency != null && !clientDependency.isEmpty();
			case UML2Package.CHANGE_TRIGGER__NAME_EXPRESSION:
				return nameExpression != null;
			case UML2Package.CHANGE_TRIGGER__PORT:
				return port != null && !port.isEmpty();
			case UML2Package.CHANGE_TRIGGER__CHANGE_EXPRESSION:
				return changeExpression != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //ChangeTriggerImpl
