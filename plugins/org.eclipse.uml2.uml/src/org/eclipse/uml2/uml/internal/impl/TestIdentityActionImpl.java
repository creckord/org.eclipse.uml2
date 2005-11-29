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
 * $Id: TestIdentityActionImpl.java,v 1.5 2005/11/28 20:26:03 khussey Exp $
 */
package org.eclipse.uml2.uml.internal.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.TestIdentityAction;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

import org.eclipse.uml2.uml.internal.operations.TestIdentityActionOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Identity Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.TestIdentityActionImpl#getInputs <em>Input</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.TestIdentityActionImpl#getOutputs <em>Output</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.TestIdentityActionImpl#getFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.TestIdentityActionImpl#getSecond <em>Second</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.TestIdentityActionImpl#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestIdentityActionImpl
		extends ActionImpl
		implements TestIdentityAction {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestIdentityActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UMLPackage.Literals.TEST_IDENTITY_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getInputs() {
		List input = (List) eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__INPUT);
		if (input == null) {
			eVirtualSet(UMLPackage.TEST_IDENTITY_ACTION__INPUT,
				input = new DerivedUnionEObjectEList(InputPin.class, this,
					UMLPackage.TEST_IDENTITY_ACTION__INPUT, new int[]{
						UMLPackage.TEST_IDENTITY_ACTION__FIRST,
						UMLPackage.TEST_IDENTITY_ACTION__SECOND}));
		}
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getOutputs() {
		List output = (List) eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__OUTPUT);
		if (output == null) {
			eVirtualSet(UMLPackage.TEST_IDENTITY_ACTION__OUTPUT,
				output = new DerivedUnionEObjectEList(OutputPin.class, this,
					UMLPackage.TEST_IDENTITY_ACTION__OUTPUT,
					new int[]{UMLPackage.TEST_IDENTITY_ACTION__RESULT}));
		}
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPin getFirst() {
		return (InputPin) eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__FIRST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirst(InputPin newFirst,
			NotificationChain msgs) {
		Object oldFirst = eVirtualSet(UMLPackage.TEST_IDENTITY_ACTION__FIRST,
			newFirst);
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET, UMLPackage.TEST_IDENTITY_ACTION__FIRST,
				oldFirst == EVIRTUAL_NO_VALUE
					? null
					: oldFirst, newFirst);
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
	public void setFirst(InputPin newFirst) {
		InputPin first = (InputPin) eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__FIRST);
		if (newFirst != first) {
			NotificationChain msgs = null;
			if (first != null)
				msgs = ((InternalEObject) first).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- UMLPackage.TEST_IDENTITY_ACTION__FIRST, null, msgs);
			if (newFirst != null)
				msgs = ((InternalEObject) newFirst).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- UMLPackage.TEST_IDENTITY_ACTION__FIRST, null, msgs);
			msgs = basicSetFirst(newFirst, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.TEST_IDENTITY_ACTION__FIRST, newFirst, newFirst));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPin createFirst(EClass eClass) {
		InputPin newFirst = (InputPin) eClass.getEPackage()
			.getEFactoryInstance().create(eClass);
		setFirst(newFirst);
		return newFirst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPin createFirst() {
		InputPin newFirst = UMLFactory.eINSTANCE.createInputPin();
		setFirst(newFirst);
		return newFirst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPin getSecond() {
		return (InputPin) eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__SECOND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSecond(InputPin newSecond,
			NotificationChain msgs) {
		Object oldSecond = eVirtualSet(UMLPackage.TEST_IDENTITY_ACTION__SECOND,
			newSecond);
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET, UMLPackage.TEST_IDENTITY_ACTION__SECOND,
				oldSecond == EVIRTUAL_NO_VALUE
					? null
					: oldSecond, newSecond);
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
	public void setSecond(InputPin newSecond) {
		InputPin second = (InputPin) eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__SECOND);
		if (newSecond != second) {
			NotificationChain msgs = null;
			if (second != null)
				msgs = ((InternalEObject) second).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- UMLPackage.TEST_IDENTITY_ACTION__SECOND, null, msgs);
			if (newSecond != null)
				msgs = ((InternalEObject) newSecond).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- UMLPackage.TEST_IDENTITY_ACTION__SECOND, null, msgs);
			msgs = basicSetSecond(newSecond, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.TEST_IDENTITY_ACTION__SECOND, newSecond, newSecond));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPin createSecond(EClass eClass) {
		InputPin newSecond = (InputPin) eClass.getEPackage()
			.getEFactoryInstance().create(eClass);
		setSecond(newSecond);
		return newSecond;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPin createSecond() {
		InputPin newSecond = UMLFactory.eINSTANCE.createInputPin();
		setSecond(newSecond);
		return newSecond;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPin getResult() {
		return (OutputPin) eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__RESULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResult(OutputPin newResult,
			NotificationChain msgs) {
		Object oldResult = eVirtualSet(UMLPackage.TEST_IDENTITY_ACTION__RESULT,
			newResult);
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET, UMLPackage.TEST_IDENTITY_ACTION__RESULT,
				oldResult == EVIRTUAL_NO_VALUE
					? null
					: oldResult, newResult);
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
	public void setResult(OutputPin newResult) {
		OutputPin result = (OutputPin) eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__RESULT);
		if (newResult != result) {
			NotificationChain msgs = null;
			if (result != null)
				msgs = ((InternalEObject) result).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- UMLPackage.TEST_IDENTITY_ACTION__RESULT, null, msgs);
			if (newResult != null)
				msgs = ((InternalEObject) newResult).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- UMLPackage.TEST_IDENTITY_ACTION__RESULT, null, msgs);
			msgs = basicSetResult(newResult, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.TEST_IDENTITY_ACTION__RESULT, newResult, newResult));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPin createResult() {
		OutputPin newResult = UMLFactory.eINSTANCE.createOutputPin();
		setResult(newResult);
		return newResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNoType(DiagnosticChain diagnostics, Map context) {
		return TestIdentityActionOperations.validateNoType(this, diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiplicity(DiagnosticChain diagnostics, Map context) {
		return TestIdentityActionOperations.validateMultiplicity(this,
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResultIsBoolean(DiagnosticChain diagnostics,
			Map context) {
		return TestIdentityActionOperations.validateResultIsBoolean(this,
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLPackage.TEST_IDENTITY_ACTION__EANNOTATIONS :
				return ((InternalEList) getEAnnotations()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.TEST_IDENTITY_ACTION__OWNED_COMMENT :
				return ((InternalEList) getOwnedComments()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.TEST_IDENTITY_ACTION__CLIENT_DEPENDENCY :
				return ((InternalEList) getClientDependencies()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.TEST_IDENTITY_ACTION__NAME_EXPRESSION :
				return basicSetNameExpression(null, msgs);
			case UMLPackage.TEST_IDENTITY_ACTION__OUTGOING :
				return ((InternalEList) getOutgoings()).basicRemove(otherEnd,
					msgs);
			case UMLPackage.TEST_IDENTITY_ACTION__IN_PARTITION :
				return ((InternalEList) getInPartitions()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.TEST_IDENTITY_ACTION__IN_STRUCTURED_NODE :
				return eBasicSetContainer(null,
					UMLPackage.TEST_IDENTITY_ACTION__IN_STRUCTURED_NODE, msgs);
			case UMLPackage.TEST_IDENTITY_ACTION__ACTIVITY :
				return eBasicSetContainer(null,
					UMLPackage.TEST_IDENTITY_ACTION__ACTIVITY, msgs);
			case UMLPackage.TEST_IDENTITY_ACTION__INCOMING :
				return ((InternalEList) getIncomings()).basicRemove(otherEnd,
					msgs);
			case UMLPackage.TEST_IDENTITY_ACTION__IN_INTERRUPTIBLE_REGION :
				return ((InternalEList) getInInterruptibleRegions())
					.basicRemove(otherEnd, msgs);
			case UMLPackage.TEST_IDENTITY_ACTION__HANDLER :
				return ((InternalEList) getHandlers()).basicRemove(otherEnd,
					msgs);
			case UMLPackage.TEST_IDENTITY_ACTION__LOCAL_PRECONDITION :
				return ((InternalEList) getLocalPreconditions()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.TEST_IDENTITY_ACTION__LOCAL_POSTCONDITION :
				return ((InternalEList) getLocalPostconditions()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.TEST_IDENTITY_ACTION__FIRST :
				return basicSetFirst(null, msgs);
			case UMLPackage.TEST_IDENTITY_ACTION__SECOND :
				return basicSetSecond(null, msgs);
			case UMLPackage.TEST_IDENTITY_ACTION__RESULT :
				return basicSetResult(null, msgs);
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
			case UMLPackage.TEST_IDENTITY_ACTION__EANNOTATIONS :
				return getEAnnotations();
			case UMLPackage.TEST_IDENTITY_ACTION__OWNED_ELEMENT :
				return getOwnedElements();
			case UMLPackage.TEST_IDENTITY_ACTION__OWNER :
				return getOwner();
			case UMLPackage.TEST_IDENTITY_ACTION__OWNED_COMMENT :
				return getOwnedComments();
			case UMLPackage.TEST_IDENTITY_ACTION__NAME :
				return getName();
			case UMLPackage.TEST_IDENTITY_ACTION__VISIBILITY :
				return getVisibility();
			case UMLPackage.TEST_IDENTITY_ACTION__QUALIFIED_NAME :
				return getQualifiedName();
			case UMLPackage.TEST_IDENTITY_ACTION__CLIENT_DEPENDENCY :
				return getClientDependencies();
			case UMLPackage.TEST_IDENTITY_ACTION__NAMESPACE :
				if (resolve)
					return getNamespace();
				return basicGetNamespace();
			case UMLPackage.TEST_IDENTITY_ACTION__NAME_EXPRESSION :
				return getNameExpression();
			case UMLPackage.TEST_IDENTITY_ACTION__IS_LEAF :
				return isLeaf()
					? Boolean.TRUE
					: Boolean.FALSE;
			case UMLPackage.TEST_IDENTITY_ACTION__REDEFINED_ELEMENT :
				return getRedefinedElements();
			case UMLPackage.TEST_IDENTITY_ACTION__REDEFINITION_CONTEXT :
				return getRedefinitionContexts();
			case UMLPackage.TEST_IDENTITY_ACTION__OUTGOING :
				return getOutgoings();
			case UMLPackage.TEST_IDENTITY_ACTION__IN_GROUP :
				return getInGroups();
			case UMLPackage.TEST_IDENTITY_ACTION__IN_PARTITION :
				return getInPartitions();
			case UMLPackage.TEST_IDENTITY_ACTION__IN_STRUCTURED_NODE :
				return getInStructuredNode();
			case UMLPackage.TEST_IDENTITY_ACTION__ACTIVITY :
				return getActivity();
			case UMLPackage.TEST_IDENTITY_ACTION__INCOMING :
				return getIncomings();
			case UMLPackage.TEST_IDENTITY_ACTION__IN_INTERRUPTIBLE_REGION :
				return getInInterruptibleRegions();
			case UMLPackage.TEST_IDENTITY_ACTION__REDEFINED_NODE :
				return getRedefinedNodes();
			case UMLPackage.TEST_IDENTITY_ACTION__HANDLER :
				return getHandlers();
			case UMLPackage.TEST_IDENTITY_ACTION__OUTPUT :
				return getOutputs();
			case UMLPackage.TEST_IDENTITY_ACTION__INPUT :
				return getInputs();
			case UMLPackage.TEST_IDENTITY_ACTION__CONTEXT :
				return getContext();
			case UMLPackage.TEST_IDENTITY_ACTION__LOCAL_PRECONDITION :
				return getLocalPreconditions();
			case UMLPackage.TEST_IDENTITY_ACTION__LOCAL_POSTCONDITION :
				return getLocalPostconditions();
			case UMLPackage.TEST_IDENTITY_ACTION__FIRST :
				return getFirst();
			case UMLPackage.TEST_IDENTITY_ACTION__SECOND :
				return getSecond();
			case UMLPackage.TEST_IDENTITY_ACTION__RESULT :
				return getResult();
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
			case UMLPackage.TEST_IDENTITY_ACTION__EANNOTATIONS :
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection) newValue);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__OWNED_COMMENT :
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection) newValue);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__NAME :
				setName((String) newValue);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__VISIBILITY :
				setVisibility((VisibilityKind) newValue);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection) newValue);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__NAME_EXPRESSION :
				setNameExpression((StringExpression) newValue);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__IS_LEAF :
				setIsLeaf(((Boolean) newValue).booleanValue());
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__OUTGOING :
				getOutgoings().clear();
				getOutgoings().addAll((Collection) newValue);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__IN_PARTITION :
				getInPartitions().clear();
				getInPartitions().addAll((Collection) newValue);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__IN_STRUCTURED_NODE :
				setInStructuredNode((StructuredActivityNode) newValue);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__ACTIVITY :
				setActivity((Activity) newValue);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__INCOMING :
				getIncomings().clear();
				getIncomings().addAll((Collection) newValue);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__IN_INTERRUPTIBLE_REGION :
				getInInterruptibleRegions().clear();
				getInInterruptibleRegions().addAll((Collection) newValue);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__REDEFINED_NODE :
				getRedefinedNodes().clear();
				getRedefinedNodes().addAll((Collection) newValue);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__HANDLER :
				getHandlers().clear();
				getHandlers().addAll((Collection) newValue);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__LOCAL_PRECONDITION :
				getLocalPreconditions().clear();
				getLocalPreconditions().addAll((Collection) newValue);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__LOCAL_POSTCONDITION :
				getLocalPostconditions().clear();
				getLocalPostconditions().addAll((Collection) newValue);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__FIRST :
				setFirst((InputPin) newValue);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__SECOND :
				setSecond((InputPin) newValue);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__RESULT :
				setResult((OutputPin) newValue);
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
			case UMLPackage.TEST_IDENTITY_ACTION__EANNOTATIONS :
				getEAnnotations().clear();
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__OWNED_COMMENT :
				getOwnedComments().clear();
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__NAME :
				setName(NAME_EDEFAULT);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__VISIBILITY :
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__NAME_EXPRESSION :
				setNameExpression((StringExpression) null);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__IS_LEAF :
				setIsLeaf(IS_LEAF_EDEFAULT);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__OUTGOING :
				getOutgoings().clear();
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__IN_PARTITION :
				getInPartitions().clear();
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__IN_STRUCTURED_NODE :
				setInStructuredNode((StructuredActivityNode) null);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__ACTIVITY :
				setActivity((Activity) null);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__INCOMING :
				getIncomings().clear();
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__IN_INTERRUPTIBLE_REGION :
				getInInterruptibleRegions().clear();
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__REDEFINED_NODE :
				getRedefinedNodes().clear();
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__HANDLER :
				getHandlers().clear();
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__LOCAL_PRECONDITION :
				getLocalPreconditions().clear();
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__LOCAL_POSTCONDITION :
				getLocalPostconditions().clear();
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__FIRST :
				setFirst((InputPin) null);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__SECOND :
				setSecond((InputPin) null);
				return;
			case UMLPackage.TEST_IDENTITY_ACTION__RESULT :
				setResult((OutputPin) null);
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
			case UMLPackage.TEST_IDENTITY_ACTION__EANNOTATIONS :
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UMLPackage.TEST_IDENTITY_ACTION__OWNED_ELEMENT :
				return isSetOwnedElements();
			case UMLPackage.TEST_IDENTITY_ACTION__OWNER :
				return isSetOwner();
			case UMLPackage.TEST_IDENTITY_ACTION__OWNED_COMMENT :
				List ownedComment = (List) eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__OWNED_COMMENT);
				return ownedComment != null && !ownedComment.isEmpty();
			case UMLPackage.TEST_IDENTITY_ACTION__NAME :
				String name = (String) eVirtualGet(
					UMLPackage.TEST_IDENTITY_ACTION__NAME, NAME_EDEFAULT);
				return NAME_EDEFAULT == null
					? name != null
					: !NAME_EDEFAULT.equals(name);
			case UMLPackage.TEST_IDENTITY_ACTION__VISIBILITY :
				return eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__VISIBILITY,
					VISIBILITY_EDEFAULT) != VISIBILITY_EDEFAULT;
			case UMLPackage.TEST_IDENTITY_ACTION__QUALIFIED_NAME :
				return QUALIFIED_NAME_EDEFAULT == null
					? getQualifiedName() != null
					: !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UMLPackage.TEST_IDENTITY_ACTION__CLIENT_DEPENDENCY :
				List clientDependency = (List) eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__CLIENT_DEPENDENCY);
				return clientDependency != null && !clientDependency.isEmpty();
			case UMLPackage.TEST_IDENTITY_ACTION__NAMESPACE :
				return isSetNamespace();
			case UMLPackage.TEST_IDENTITY_ACTION__NAME_EXPRESSION :
				return eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__NAME_EXPRESSION) != null;
			case UMLPackage.TEST_IDENTITY_ACTION__IS_LEAF :
				return ((eFlags & IS_LEAF_EFLAG) != 0) != IS_LEAF_EDEFAULT;
			case UMLPackage.TEST_IDENTITY_ACTION__REDEFINED_ELEMENT :
				return isSetRedefinedElements();
			case UMLPackage.TEST_IDENTITY_ACTION__REDEFINITION_CONTEXT :
				return isSetRedefinitionContexts();
			case UMLPackage.TEST_IDENTITY_ACTION__OUTGOING :
				List outgoing = (List) eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__OUTGOING);
				return outgoing != null && !outgoing.isEmpty();
			case UMLPackage.TEST_IDENTITY_ACTION__IN_GROUP :
				return isSetInGroups();
			case UMLPackage.TEST_IDENTITY_ACTION__IN_PARTITION :
				List inPartition = (List) eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__IN_PARTITION);
				return inPartition != null && !inPartition.isEmpty();
			case UMLPackage.TEST_IDENTITY_ACTION__IN_STRUCTURED_NODE :
				return getInStructuredNode() != null;
			case UMLPackage.TEST_IDENTITY_ACTION__ACTIVITY :
				return getActivity() != null;
			case UMLPackage.TEST_IDENTITY_ACTION__INCOMING :
				List incoming = (List) eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__INCOMING);
				return incoming != null && !incoming.isEmpty();
			case UMLPackage.TEST_IDENTITY_ACTION__IN_INTERRUPTIBLE_REGION :
				List inInterruptibleRegion = (List) eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__IN_INTERRUPTIBLE_REGION);
				return inInterruptibleRegion != null
					&& !inInterruptibleRegion.isEmpty();
			case UMLPackage.TEST_IDENTITY_ACTION__REDEFINED_NODE :
				List redefinedNode = (List) eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__REDEFINED_NODE);
				return redefinedNode != null && !redefinedNode.isEmpty();
			case UMLPackage.TEST_IDENTITY_ACTION__HANDLER :
				List handler = (List) eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__HANDLER);
				return handler != null && !handler.isEmpty();
			case UMLPackage.TEST_IDENTITY_ACTION__OUTPUT :
				return isSetOutputs();
			case UMLPackage.TEST_IDENTITY_ACTION__INPUT :
				return isSetInputs();
			case UMLPackage.TEST_IDENTITY_ACTION__CONTEXT :
				return getContext() != null;
			case UMLPackage.TEST_IDENTITY_ACTION__LOCAL_PRECONDITION :
				List localPrecondition = (List) eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__LOCAL_PRECONDITION);
				return localPrecondition != null
					&& !localPrecondition.isEmpty();
			case UMLPackage.TEST_IDENTITY_ACTION__LOCAL_POSTCONDITION :
				List localPostcondition = (List) eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__LOCAL_POSTCONDITION);
				return localPostcondition != null
					&& !localPostcondition.isEmpty();
			case UMLPackage.TEST_IDENTITY_ACTION__FIRST :
				return eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__FIRST) != null;
			case UMLPackage.TEST_IDENTITY_ACTION__SECOND :
				return eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__SECOND) != null;
			case UMLPackage.TEST_IDENTITY_ACTION__RESULT :
				return eVirtualGet(UMLPackage.TEST_IDENTITY_ACTION__RESULT) != null;
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInputs() {
		return super.isSetInputs()
			|| eIsSet(UMLPackage.TEST_IDENTITY_ACTION__FIRST)
			|| eIsSet(UMLPackage.TEST_IDENTITY_ACTION__SECOND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOutputs() {
		return super.isSetOutputs()
			|| eIsSet(UMLPackage.TEST_IDENTITY_ACTION__RESULT);
	}

} //TestIdentityActionImpl