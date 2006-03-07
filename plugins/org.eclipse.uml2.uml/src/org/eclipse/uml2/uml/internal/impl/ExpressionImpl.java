/*
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: ExpressionImpl.java,v 1.14 2006/03/07 20:25:15 khussey Exp $
 */
package org.eclipse.uml2.uml.internal.impl;

import java.util.Collection;
import java.util.Iterator;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.ExpressionImpl#getOwnedElements <em>Owned Element</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.ExpressionImpl#getSymbol <em>Symbol</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.ExpressionImpl#getOperands <em>Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionImpl
		extends ValueSpecificationImpl
		implements Expression {

	/**
	 * The default value of the '{@link #getSymbol() <em>Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbol()
	 * @generated
	 * @ordered
	 */
	protected static final String SYMBOL_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UMLPackage.Literals.EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getOwnedElements() {
		EList ownedElement = (EList) eVirtualGet(UMLPackage.EXPRESSION__OWNED_ELEMENT);
		if (ownedElement == null) {
			eVirtualSet(UMLPackage.EXPRESSION__OWNED_ELEMENT,
				ownedElement = new DerivedUnionEObjectEList(Element.class,
					this, UMLPackage.EXPRESSION__OWNED_ELEMENT, new int[]{
						UMLPackage.EXPRESSION__OWNED_COMMENT,
						UMLPackage.EXPRESSION__NAME_EXPRESSION,
						UMLPackage.EXPRESSION__OPERAND}));
		}
		return ownedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSymbol() {
		return (String) eVirtualGet(UMLPackage.EXPRESSION__SYMBOL,
			SYMBOL_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSymbol(String newSymbol) {
		String symbol = newSymbol;
		Object oldSymbol = eVirtualSet(UMLPackage.EXPRESSION__SYMBOL, symbol);
		boolean isSetChange = oldSymbol == EVIRTUAL_NO_VALUE;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.EXPRESSION__SYMBOL, isSetChange
					? SYMBOL_EDEFAULT
					: oldSymbol, symbol, isSetChange));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSymbol() {
		Object oldSymbol = eVirtualUnset(UMLPackage.EXPRESSION__SYMBOL);
		boolean isSetChange = oldSymbol != EVIRTUAL_NO_VALUE;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
				UMLPackage.EXPRESSION__SYMBOL, isSetChange
					? oldSymbol
					: SYMBOL_EDEFAULT, SYMBOL_EDEFAULT, isSetChange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSymbol() {
		return eVirtualIsSet(UMLPackage.EXPRESSION__SYMBOL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getOperands() {
		EList operand = (EList) eVirtualGet(UMLPackage.EXPRESSION__OPERAND);
		if (operand == null) {
			eVirtualSet(UMLPackage.EXPRESSION__OPERAND,
				operand = new EObjectContainmentEList.Resolving(
					ValueSpecification.class, this,
					UMLPackage.EXPRESSION__OPERAND));
		}
		return operand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSpecification createOperand(String name, Type type,
			EClass eClass) {
		ValueSpecification newOperand = (ValueSpecification) create(eClass);
		if (name != null)
			newOperand.setName(name);
		if (type != null)
			newOperand.setType(type);
		getOperands().add(newOperand);
		return newOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSpecification getOperand(String name, Type type) {
		return getOperand(name, type, false, null, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSpecification getOperand(String name, Type type,
			boolean ignoreCase, EClass eClass, boolean createOnDemand) {
		operandLoop : for (Iterator i = getOperands().iterator(); i.hasNext();) {
			ValueSpecification operand = (ValueSpecification) i.next();
			if (eClass != null && !eClass.isInstance(operand))
				continue operandLoop;
			if (name != null && !(ignoreCase
				? name.equalsIgnoreCase(operand.getName())
				: name.equals(operand.getName())))
				continue operandLoop;
			if (type != null && !type.equals(operand.getType()))
				continue operandLoop;
			return operand;
		}
		return createOnDemand && eClass != null
			? createOperand(name, type, eClass)
			: null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLPackage.EXPRESSION__EANNOTATIONS :
				return ((InternalEList) getEAnnotations()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.EXPRESSION__OWNED_COMMENT :
				return ((InternalEList) getOwnedComments()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.EXPRESSION__CLIENT_DEPENDENCY :
				return ((InternalEList) getClientDependencies()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.EXPRESSION__NAME_EXPRESSION :
				return basicSetNameExpression(null, msgs);
			case UMLPackage.EXPRESSION__OWNING_TEMPLATE_PARAMETER :
				return basicSetOwningTemplateParameter(null, msgs);
			case UMLPackage.EXPRESSION__TEMPLATE_PARAMETER :
				return basicSetTemplateParameter(null, msgs);
			case UMLPackage.EXPRESSION__OPERAND :
				return ((InternalEList) getOperands()).basicRemove(otherEnd,
					msgs);
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
			case UMLPackage.EXPRESSION__EANNOTATIONS :
				return getEAnnotations();
			case UMLPackage.EXPRESSION__OWNED_ELEMENT :
				return getOwnedElements();
			case UMLPackage.EXPRESSION__OWNER :
				if (resolve)
					return getOwner();
				return basicGetOwner();
			case UMLPackage.EXPRESSION__OWNED_COMMENT :
				return getOwnedComments();
			case UMLPackage.EXPRESSION__NAME :
				return getName();
			case UMLPackage.EXPRESSION__VISIBILITY :
				return getVisibility();
			case UMLPackage.EXPRESSION__QUALIFIED_NAME :
				return getQualifiedName();
			case UMLPackage.EXPRESSION__CLIENT_DEPENDENCY :
				return getClientDependencies();
			case UMLPackage.EXPRESSION__NAMESPACE :
				if (resolve)
					return getNamespace();
				return basicGetNamespace();
			case UMLPackage.EXPRESSION__NAME_EXPRESSION :
				if (resolve)
					return getNameExpression();
				return basicGetNameExpression();
			case UMLPackage.EXPRESSION__OWNING_TEMPLATE_PARAMETER :
				if (resolve)
					return getOwningTemplateParameter();
				return basicGetOwningTemplateParameter();
			case UMLPackage.EXPRESSION__TEMPLATE_PARAMETER :
				if (resolve)
					return getTemplateParameter();
				return basicGetTemplateParameter();
			case UMLPackage.EXPRESSION__TYPE :
				if (resolve)
					return getType();
				return basicGetType();
			case UMLPackage.EXPRESSION__SYMBOL :
				return getSymbol();
			case UMLPackage.EXPRESSION__OPERAND :
				return getOperands();
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
			case UMLPackage.EXPRESSION__EANNOTATIONS :
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection) newValue);
				return;
			case UMLPackage.EXPRESSION__OWNED_COMMENT :
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection) newValue);
				return;
			case UMLPackage.EXPRESSION__NAME :
				setName((String) newValue);
				return;
			case UMLPackage.EXPRESSION__VISIBILITY :
				setVisibility((VisibilityKind) newValue);
				return;
			case UMLPackage.EXPRESSION__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection) newValue);
				return;
			case UMLPackage.EXPRESSION__NAME_EXPRESSION :
				setNameExpression((StringExpression) newValue);
				return;
			case UMLPackage.EXPRESSION__OWNING_TEMPLATE_PARAMETER :
				setOwningTemplateParameter((TemplateParameter) newValue);
				return;
			case UMLPackage.EXPRESSION__TEMPLATE_PARAMETER :
				setTemplateParameter((TemplateParameter) newValue);
				return;
			case UMLPackage.EXPRESSION__TYPE :
				setType((Type) newValue);
				return;
			case UMLPackage.EXPRESSION__SYMBOL :
				setSymbol((String) newValue);
				return;
			case UMLPackage.EXPRESSION__OPERAND :
				getOperands().clear();
				getOperands().addAll((Collection) newValue);
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
			case UMLPackage.EXPRESSION__EANNOTATIONS :
				getEAnnotations().clear();
				return;
			case UMLPackage.EXPRESSION__OWNED_COMMENT :
				getOwnedComments().clear();
				return;
			case UMLPackage.EXPRESSION__NAME :
				unsetName();
				return;
			case UMLPackage.EXPRESSION__VISIBILITY :
				unsetVisibility();
				return;
			case UMLPackage.EXPRESSION__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				return;
			case UMLPackage.EXPRESSION__NAME_EXPRESSION :
				setNameExpression((StringExpression) null);
				return;
			case UMLPackage.EXPRESSION__OWNING_TEMPLATE_PARAMETER :
				setOwningTemplateParameter((TemplateParameter) null);
				return;
			case UMLPackage.EXPRESSION__TEMPLATE_PARAMETER :
				setTemplateParameter((TemplateParameter) null);
				return;
			case UMLPackage.EXPRESSION__TYPE :
				setType((Type) null);
				return;
			case UMLPackage.EXPRESSION__SYMBOL :
				unsetSymbol();
				return;
			case UMLPackage.EXPRESSION__OPERAND :
				getOperands().clear();
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
			case UMLPackage.EXPRESSION__EANNOTATIONS :
				EList eAnnotations = (EList) eVirtualGet(UMLPackage.EXPRESSION__EANNOTATIONS);
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UMLPackage.EXPRESSION__OWNED_ELEMENT :
				return isSetOwnedElements();
			case UMLPackage.EXPRESSION__OWNER :
				return isSetOwner();
			case UMLPackage.EXPRESSION__OWNED_COMMENT :
				EList ownedComment = (EList) eVirtualGet(UMLPackage.EXPRESSION__OWNED_COMMENT);
				return ownedComment != null && !ownedComment.isEmpty();
			case UMLPackage.EXPRESSION__NAME :
				return isSetName();
			case UMLPackage.EXPRESSION__VISIBILITY :
				return isSetVisibility();
			case UMLPackage.EXPRESSION__QUALIFIED_NAME :
				return QUALIFIED_NAME_EDEFAULT == null
					? getQualifiedName() != null
					: !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UMLPackage.EXPRESSION__CLIENT_DEPENDENCY :
				EList clientDependency = (EList) eVirtualGet(UMLPackage.EXPRESSION__CLIENT_DEPENDENCY);
				return clientDependency != null && !clientDependency.isEmpty();
			case UMLPackage.EXPRESSION__NAMESPACE :
				return isSetNamespace();
			case UMLPackage.EXPRESSION__NAME_EXPRESSION :
				return eVirtualGet(UMLPackage.EXPRESSION__NAME_EXPRESSION) != null;
			case UMLPackage.EXPRESSION__OWNING_TEMPLATE_PARAMETER :
				return basicGetOwningTemplateParameter() != null;
			case UMLPackage.EXPRESSION__TEMPLATE_PARAMETER :
				return eVirtualGet(UMLPackage.EXPRESSION__TEMPLATE_PARAMETER) != null;
			case UMLPackage.EXPRESSION__TYPE :
				return eVirtualGet(UMLPackage.EXPRESSION__TYPE) != null;
			case UMLPackage.EXPRESSION__SYMBOL :
				return isSetSymbol();
			case UMLPackage.EXPRESSION__OPERAND :
				EList operand = (EList) eVirtualGet(UMLPackage.EXPRESSION__OPERAND);
				return operand != null && !operand.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (symbol: "); //$NON-NLS-1$
		if (eVirtualIsSet(UMLPackage.EXPRESSION__SYMBOL))
			result.append(eVirtualGet(UMLPackage.EXPRESSION__SYMBOL));
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedElements() {
		return super.isSetOwnedElements()
			|| eIsSet(UMLPackage.EXPRESSION__OPERAND);
	}

} //ExpressionImpl
