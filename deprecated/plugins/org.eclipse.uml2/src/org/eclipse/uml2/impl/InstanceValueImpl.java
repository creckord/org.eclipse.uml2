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
 * $Id: InstanceValueImpl.java,v 1.17 2006/04/10 20:40:20 khussey Exp $
 */
package org.eclipse.uml2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.uml2.EnumerationLiteral;
import org.eclipse.uml2.InstanceSpecification;
import org.eclipse.uml2.InstanceValue;
import org.eclipse.uml2.StringExpression;
import org.eclipse.uml2.TemplateParameter;
import org.eclipse.uml2.TemplateSignature;
import org.eclipse.uml2.Type;
import org.eclipse.uml2.UML2Package;
import org.eclipse.uml2.ValueSpecification;
import org.eclipse.uml2.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.impl.InstanceValueImpl#getInstance <em>Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstanceValueImpl extends ValueSpecificationImpl implements InstanceValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) IBM Corporation and others."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getInstance() <em>Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstance()
	 * @generated
	 * @ordered
	 */
	protected InstanceSpecification instance = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UML2Package.Literals.INSTANCE_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceSpecification getInstance() {
		if (instance != null && instance.eIsProxy()) {
			InternalEObject oldInstance = (InternalEObject)instance;
			instance = (InstanceSpecification)eResolveProxy(oldInstance);
			if (instance != oldInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UML2Package.INSTANCE_VALUE__INSTANCE, oldInstance, instance));
			}
		}
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceSpecification basicGetInstance() {
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstance(InstanceSpecification newInstance) {
		InstanceSpecification oldInstance = instance;
		instance = newInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2Package.INSTANCE_VALUE__INSTANCE, oldInstance, instance));


	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UML2Package.INSTANCE_VALUE__EANNOTATIONS:
				return getEAnnotations();
			case UML2Package.INSTANCE_VALUE__OWNED_ELEMENT:
				return getOwnedElements();
			case UML2Package.INSTANCE_VALUE__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case UML2Package.INSTANCE_VALUE__OWNED_COMMENT:
				return getOwnedComments();
			case UML2Package.INSTANCE_VALUE__TEMPLATE_BINDING:
				return getTemplateBindings();
			case UML2Package.INSTANCE_VALUE__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case UML2Package.INSTANCE_VALUE__NAME:
				return getName();
			case UML2Package.INSTANCE_VALUE__QUALIFIED_NAME:
				return getQualifiedName();
			case UML2Package.INSTANCE_VALUE__VISIBILITY:
				return getVisibility();
			case UML2Package.INSTANCE_VALUE__CLIENT_DEPENDENCY:
				return getClientDependencies();
			case UML2Package.INSTANCE_VALUE__NAME_EXPRESSION:
				return getNameExpression();
			case UML2Package.INSTANCE_VALUE__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case UML2Package.INSTANCE_VALUE__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case UML2Package.INSTANCE_VALUE__OWNING_PARAMETER:
				return getOwningParameter();
			case UML2Package.INSTANCE_VALUE__INSTANCE:
				if (resolve) return getInstance();
				return basicGetInstance();
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
			case UML2Package.INSTANCE_VALUE__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case UML2Package.INSTANCE_VALUE__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection)newValue);
				return;
			case UML2Package.INSTANCE_VALUE__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection)newValue);
				return;
			case UML2Package.INSTANCE_VALUE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case UML2Package.INSTANCE_VALUE__NAME:
				setName((String)newValue);
				return;
			case UML2Package.INSTANCE_VALUE__VISIBILITY:
				setVisibility((VisibilityKind)newValue);
				return;
			case UML2Package.INSTANCE_VALUE__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection)newValue);
				return;
			case UML2Package.INSTANCE_VALUE__NAME_EXPRESSION:
				setNameExpression((StringExpression)newValue);
				return;
			case UML2Package.INSTANCE_VALUE__TYPE:
				setType((Type)newValue);
				return;
			case UML2Package.INSTANCE_VALUE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case UML2Package.INSTANCE_VALUE__OWNING_PARAMETER:
				setOwningParameter((TemplateParameter)newValue);
				return;
			case UML2Package.INSTANCE_VALUE__INSTANCE:
				setInstance((InstanceSpecification)newValue);
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
			case UML2Package.INSTANCE_VALUE__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case UML2Package.INSTANCE_VALUE__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case UML2Package.INSTANCE_VALUE__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				return;
			case UML2Package.INSTANCE_VALUE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case UML2Package.INSTANCE_VALUE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UML2Package.INSTANCE_VALUE__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case UML2Package.INSTANCE_VALUE__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				return;
			case UML2Package.INSTANCE_VALUE__NAME_EXPRESSION:
				setNameExpression((StringExpression)null);
				return;
			case UML2Package.INSTANCE_VALUE__TYPE:
				setType((Type)null);
				return;
			case UML2Package.INSTANCE_VALUE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case UML2Package.INSTANCE_VALUE__OWNING_PARAMETER:
				setOwningParameter((TemplateParameter)null);
				return;
			case UML2Package.INSTANCE_VALUE__INSTANCE:
				setInstance((InstanceSpecification)null);
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
			case UML2Package.INSTANCE_VALUE__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UML2Package.INSTANCE_VALUE__OWNED_ELEMENT:
				return isSetOwnedElements();
			case UML2Package.INSTANCE_VALUE__OWNER:
				return isSetOwner();
			case UML2Package.INSTANCE_VALUE__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case UML2Package.INSTANCE_VALUE__TEMPLATE_BINDING:
				return templateBindings != null && !templateBindings.isEmpty();
			case UML2Package.INSTANCE_VALUE__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case UML2Package.INSTANCE_VALUE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UML2Package.INSTANCE_VALUE__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? getQualifiedName() != null : !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UML2Package.INSTANCE_VALUE__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case UML2Package.INSTANCE_VALUE__CLIENT_DEPENDENCY:
				return clientDependencies != null && !clientDependencies.isEmpty();
			case UML2Package.INSTANCE_VALUE__NAME_EXPRESSION:
				return nameExpression != null;
			case UML2Package.INSTANCE_VALUE__TYPE:
				return type != null;
			case UML2Package.INSTANCE_VALUE__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case UML2Package.INSTANCE_VALUE__OWNING_PARAMETER:
				return getOwningParameter() != null;
			case UML2Package.INSTANCE_VALUE__INSTANCE:
				return instance != null;
		}
		return eDynamicIsSet(featureID);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.ValueSpecification#stringValue()
	 */
	public String stringValue() {
		InstanceSpecification instance = getInstance();

		if (EnumerationLiteral.class.isInstance(instance)) {
			return ((EnumerationLiteral) instance).getName();
		} else if (null != instance) {
			ValueSpecification specification = instance.getSpecification();

			if (null != specification) {
				return specification.stringValue();
			}
		}

		return super.stringValue();
	}

} // InstanceValueImpl
