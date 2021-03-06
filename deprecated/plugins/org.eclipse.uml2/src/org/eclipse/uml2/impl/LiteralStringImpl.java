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
 * $Id: LiteralStringImpl.java,v 1.17 2006/05/26 18:16:44 khussey Exp $
 */
package org.eclipse.uml2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.uml2.LiteralString;
import org.eclipse.uml2.StringExpression;
import org.eclipse.uml2.TemplateParameter;
import org.eclipse.uml2.TemplateSignature;
import org.eclipse.uml2.Type;
import org.eclipse.uml2.UML2Package;
import org.eclipse.uml2.VisibilityKind;

import org.eclipse.uml2.internal.operation.LiteralStringOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Literal String</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.impl.LiteralStringImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LiteralStringImpl extends LiteralSpecificationImpl implements LiteralString {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) IBM Corporation and others."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = ""; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LiteralStringImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UML2Package.Literals.LITERAL_STRING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		newValue = newValue == null ? VALUE_EDEFAULT : newValue;
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2Package.LITERAL_STRING__VALUE, oldValue, value));


	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComputable() {
		return LiteralStringOperations.isComputable(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String stringValue() {
		return LiteralStringOperations.stringValue(this);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UML2Package.LITERAL_STRING__EANNOTATIONS:
				return getEAnnotations();
			case UML2Package.LITERAL_STRING__OWNED_ELEMENT:
				return getOwnedElements();
			case UML2Package.LITERAL_STRING__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case UML2Package.LITERAL_STRING__OWNED_COMMENT:
				return getOwnedComments();
			case UML2Package.LITERAL_STRING__TEMPLATE_BINDING:
				return getTemplateBindings();
			case UML2Package.LITERAL_STRING__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case UML2Package.LITERAL_STRING__NAME:
				return getName();
			case UML2Package.LITERAL_STRING__QUALIFIED_NAME:
				return getQualifiedName();
			case UML2Package.LITERAL_STRING__VISIBILITY:
				return getVisibility();
			case UML2Package.LITERAL_STRING__CLIENT_DEPENDENCY:
				return getClientDependencies();
			case UML2Package.LITERAL_STRING__NAME_EXPRESSION:
				return getNameExpression();
			case UML2Package.LITERAL_STRING__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case UML2Package.LITERAL_STRING__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case UML2Package.LITERAL_STRING__OWNING_PARAMETER:
				return getOwningParameter();
			case UML2Package.LITERAL_STRING__VALUE:
				return getValue();
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
			case UML2Package.LITERAL_STRING__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case UML2Package.LITERAL_STRING__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection)newValue);
				return;
			case UML2Package.LITERAL_STRING__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection)newValue);
				return;
			case UML2Package.LITERAL_STRING__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case UML2Package.LITERAL_STRING__NAME:
				setName((String)newValue);
				return;
			case UML2Package.LITERAL_STRING__VISIBILITY:
				setVisibility((VisibilityKind)newValue);
				return;
			case UML2Package.LITERAL_STRING__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection)newValue);
				return;
			case UML2Package.LITERAL_STRING__NAME_EXPRESSION:
				setNameExpression((StringExpression)newValue);
				return;
			case UML2Package.LITERAL_STRING__TYPE:
				setType((Type)newValue);
				return;
			case UML2Package.LITERAL_STRING__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case UML2Package.LITERAL_STRING__OWNING_PARAMETER:
				setOwningParameter((TemplateParameter)newValue);
				return;
			case UML2Package.LITERAL_STRING__VALUE:
				setValue((String)newValue);
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
			case UML2Package.LITERAL_STRING__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case UML2Package.LITERAL_STRING__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case UML2Package.LITERAL_STRING__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				return;
			case UML2Package.LITERAL_STRING__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case UML2Package.LITERAL_STRING__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UML2Package.LITERAL_STRING__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case UML2Package.LITERAL_STRING__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				return;
			case UML2Package.LITERAL_STRING__NAME_EXPRESSION:
				setNameExpression((StringExpression)null);
				return;
			case UML2Package.LITERAL_STRING__TYPE:
				setType((Type)null);
				return;
			case UML2Package.LITERAL_STRING__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case UML2Package.LITERAL_STRING__OWNING_PARAMETER:
				setOwningParameter((TemplateParameter)null);
				return;
			case UML2Package.LITERAL_STRING__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case UML2Package.LITERAL_STRING__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UML2Package.LITERAL_STRING__OWNED_ELEMENT:
				return isSetOwnedElements();
			case UML2Package.LITERAL_STRING__OWNER:
				return isSetOwner();
			case UML2Package.LITERAL_STRING__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case UML2Package.LITERAL_STRING__TEMPLATE_BINDING:
				return templateBindings != null && !templateBindings.isEmpty();
			case UML2Package.LITERAL_STRING__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case UML2Package.LITERAL_STRING__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UML2Package.LITERAL_STRING__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? getQualifiedName() != null : !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UML2Package.LITERAL_STRING__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case UML2Package.LITERAL_STRING__CLIENT_DEPENDENCY:
				return clientDependencies != null && !clientDependencies.isEmpty();
			case UML2Package.LITERAL_STRING__NAME_EXPRESSION:
				return nameExpression != null;
			case UML2Package.LITERAL_STRING__TYPE:
				return type != null;
			case UML2Package.LITERAL_STRING__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case UML2Package.LITERAL_STRING__OWNING_PARAMETER:
				return getOwningParameter() != null;
			case UML2Package.LITERAL_STRING__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
		result.append(" (value: "); //$NON-NLS-1$
		result.append(value);
		result.append(')');
		return result.toString();
	}


} //LiteralStringImpl
