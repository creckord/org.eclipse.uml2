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
 * $Id: ActionImpl.java,v 1.11 2006/01/03 18:01:58 khussey Exp $
 */
package org.eclipse.uml2.uml.internal.impl;

import java.util.Collection;
import java.util.Iterator;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.ActionImpl#getOutputs <em>Output</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.ActionImpl#getOwnedElements <em>Owned Element</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.ActionImpl#getInputs <em>Input</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.ActionImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.ActionImpl#getLocalPreconditions <em>Local Precondition</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.ActionImpl#getLocalPostconditions <em>Local Postcondition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionImpl
		extends ExecutableNodeImpl
		implements Action {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UMLPackage.Literals.ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getOutputs() {
		EList output = (EList) eVirtualGet(UMLPackage.ACTION__OUTPUT);
		if (output == null) {
			eVirtualSet(UMLPackage.ACTION__OUTPUT,
				output = new DerivedUnionEObjectEList(OutputPin.class, this,
					UMLPackage.ACTION__OUTPUT, new int[]{}));
		}
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPin getOutput(String name) {
		for (Iterator i = getOutputs().iterator(); i.hasNext();) {
			OutputPin output = (OutputPin) i.next();
			if (name.equals(output.getName())) {
				return output;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getOwnedElements() {
		EList ownedElement = (EList) eVirtualGet(UMLPackage.ACTION__OWNED_ELEMENT);
		if (ownedElement == null) {
			eVirtualSet(UMLPackage.ACTION__OWNED_ELEMENT,
				ownedElement = new DerivedUnionEObjectEList(Element.class,
					this, UMLPackage.ACTION__OWNED_ELEMENT, new int[]{
						UMLPackage.ACTION__OWNED_COMMENT,
						UMLPackage.ACTION__NAME_EXPRESSION,
						UMLPackage.ACTION__HANDLER, UMLPackage.ACTION__OUTPUT,
						UMLPackage.ACTION__INPUT,
						UMLPackage.ACTION__LOCAL_PRECONDITION,
						UMLPackage.ACTION__LOCAL_POSTCONDITION}));
		}
		return ownedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getInputs() {
		EList input = (EList) eVirtualGet(UMLPackage.ACTION__INPUT);
		if (input == null) {
			eVirtualSet(UMLPackage.ACTION__INPUT,
				input = new DerivedUnionEObjectEList(InputPin.class, this,
					UMLPackage.ACTION__INPUT, new int[]{}));
		}
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPin getInput(String name) {
		for (Iterator i = getInputs().iterator(); i.hasNext();) {
			InputPin input = (InputPin) i.next();
			if (name.equals(input.getName())) {
				return input;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Classifier getContext() {
		return eInternalContainer() instanceof Behavior
			? ((Behavior) eContainer()).getContext()
			: null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLocalPreconditions() {
		EList localPrecondition = (EList) eVirtualGet(UMLPackage.ACTION__LOCAL_PRECONDITION);
		if (localPrecondition == null) {
			eVirtualSet(UMLPackage.ACTION__LOCAL_PRECONDITION,
				localPrecondition = new EObjectContainmentEList(
					Constraint.class, this,
					UMLPackage.ACTION__LOCAL_PRECONDITION));
		}
		return localPrecondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint createLocalPrecondition(EClass eClass) {
		Constraint newLocalPrecondition = (Constraint) eClass.getEPackage()
			.getEFactoryInstance().create(eClass);
		getLocalPreconditions().add(newLocalPrecondition);
		return newLocalPrecondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint createLocalPrecondition() {
		Constraint newLocalPrecondition = UMLFactory.eINSTANCE
			.createConstraint();
		getLocalPreconditions().add(newLocalPrecondition);
		return newLocalPrecondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint getLocalPrecondition(String name) {
		for (Iterator i = getLocalPreconditions().iterator(); i.hasNext();) {
			Constraint localPrecondition = (Constraint) i.next();
			if (name.equals(localPrecondition.getName())) {
				return localPrecondition;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLocalPostconditions() {
		EList localPostcondition = (EList) eVirtualGet(UMLPackage.ACTION__LOCAL_POSTCONDITION);
		if (localPostcondition == null) {
			eVirtualSet(UMLPackage.ACTION__LOCAL_POSTCONDITION,
				localPostcondition = new EObjectContainmentEList(
					Constraint.class, this,
					UMLPackage.ACTION__LOCAL_POSTCONDITION));
		}
		return localPostcondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint createLocalPostcondition(EClass eClass) {
		Constraint newLocalPostcondition = (Constraint) eClass.getEPackage()
			.getEFactoryInstance().create(eClass);
		getLocalPostconditions().add(newLocalPostcondition);
		return newLocalPostcondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint createLocalPostcondition() {
		Constraint newLocalPostcondition = UMLFactory.eINSTANCE
			.createConstraint();
		getLocalPostconditions().add(newLocalPostcondition);
		return newLocalPostcondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint getLocalPostcondition(String name) {
		for (Iterator i = getLocalPostconditions().iterator(); i.hasNext();) {
			Constraint localPostcondition = (Constraint) i.next();
			if (name.equals(localPostcondition.getName())) {
				return localPostcondition;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLPackage.ACTION__EANNOTATIONS :
				return ((InternalEList) getEAnnotations()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.ACTION__OWNED_COMMENT :
				return ((InternalEList) getOwnedComments()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.ACTION__CLIENT_DEPENDENCY :
				return ((InternalEList) getClientDependencies()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.ACTION__NAME_EXPRESSION :
				return basicSetNameExpression(null, msgs);
			case UMLPackage.ACTION__IN_STRUCTURED_NODE :
				return eBasicSetContainer(null,
					UMLPackage.ACTION__IN_STRUCTURED_NODE, msgs);
			case UMLPackage.ACTION__ACTIVITY :
				return eBasicSetContainer(null, UMLPackage.ACTION__ACTIVITY,
					msgs);
			case UMLPackage.ACTION__OUTGOING :
				return ((InternalEList) getOutgoings()).basicRemove(otherEnd,
					msgs);
			case UMLPackage.ACTION__INCOMING :
				return ((InternalEList) getIncomings()).basicRemove(otherEnd,
					msgs);
			case UMLPackage.ACTION__IN_PARTITION :
				return ((InternalEList) getInPartitions()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.ACTION__IN_INTERRUPTIBLE_REGION :
				return ((InternalEList) getInInterruptibleRegions())
					.basicRemove(otherEnd, msgs);
			case UMLPackage.ACTION__HANDLER :
				return ((InternalEList) getHandlers()).basicRemove(otherEnd,
					msgs);
			case UMLPackage.ACTION__LOCAL_PRECONDITION :
				return ((InternalEList) getLocalPreconditions()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.ACTION__LOCAL_POSTCONDITION :
				return ((InternalEList) getLocalPostconditions()).basicRemove(
					otherEnd, msgs);
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
			case UMLPackage.ACTION__EANNOTATIONS :
				return getEAnnotations();
			case UMLPackage.ACTION__OWNED_ELEMENT :
				return getOwnedElements();
			case UMLPackage.ACTION__OWNER :
				if (resolve)
					return getOwner();
				return basicGetOwner();
			case UMLPackage.ACTION__OWNED_COMMENT :
				return getOwnedComments();
			case UMLPackage.ACTION__NAME :
				return getName();
			case UMLPackage.ACTION__VISIBILITY :
				return getVisibility();
			case UMLPackage.ACTION__QUALIFIED_NAME :
				return getQualifiedName();
			case UMLPackage.ACTION__CLIENT_DEPENDENCY :
				return getClientDependencies();
			case UMLPackage.ACTION__NAMESPACE :
				if (resolve)
					return getNamespace();
				return basicGetNamespace();
			case UMLPackage.ACTION__NAME_EXPRESSION :
				return getNameExpression();
			case UMLPackage.ACTION__IS_LEAF :
				return isLeaf()
					? Boolean.TRUE
					: Boolean.FALSE;
			case UMLPackage.ACTION__REDEFINED_ELEMENT :
				return getRedefinedElements();
			case UMLPackage.ACTION__REDEFINITION_CONTEXT :
				return getRedefinitionContexts();
			case UMLPackage.ACTION__IN_STRUCTURED_NODE :
				return getInStructuredNode();
			case UMLPackage.ACTION__ACTIVITY :
				return getActivity();
			case UMLPackage.ACTION__OUTGOING :
				return getOutgoings();
			case UMLPackage.ACTION__INCOMING :
				return getIncomings();
			case UMLPackage.ACTION__IN_PARTITION :
				return getInPartitions();
			case UMLPackage.ACTION__IN_INTERRUPTIBLE_REGION :
				return getInInterruptibleRegions();
			case UMLPackage.ACTION__IN_GROUP :
				return getInGroups();
			case UMLPackage.ACTION__REDEFINED_NODE :
				return getRedefinedNodes();
			case UMLPackage.ACTION__HANDLER :
				return getHandlers();
			case UMLPackage.ACTION__OUTPUT :
				return getOutputs();
			case UMLPackage.ACTION__INPUT :
				return getInputs();
			case UMLPackage.ACTION__CONTEXT :
				return getContext();
			case UMLPackage.ACTION__LOCAL_PRECONDITION :
				return getLocalPreconditions();
			case UMLPackage.ACTION__LOCAL_POSTCONDITION :
				return getLocalPostconditions();
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
			case UMLPackage.ACTION__EANNOTATIONS :
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection) newValue);
				return;
			case UMLPackage.ACTION__OWNED_COMMENT :
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection) newValue);
				return;
			case UMLPackage.ACTION__NAME :
				setName((String) newValue);
				return;
			case UMLPackage.ACTION__VISIBILITY :
				setVisibility((VisibilityKind) newValue);
				return;
			case UMLPackage.ACTION__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection) newValue);
				return;
			case UMLPackage.ACTION__NAME_EXPRESSION :
				setNameExpression((StringExpression) newValue);
				return;
			case UMLPackage.ACTION__IS_LEAF :
				setIsLeaf(((Boolean) newValue).booleanValue());
				return;
			case UMLPackage.ACTION__IN_STRUCTURED_NODE :
				setInStructuredNode((StructuredActivityNode) newValue);
				return;
			case UMLPackage.ACTION__ACTIVITY :
				setActivity((Activity) newValue);
				return;
			case UMLPackage.ACTION__OUTGOING :
				getOutgoings().clear();
				getOutgoings().addAll((Collection) newValue);
				return;
			case UMLPackage.ACTION__INCOMING :
				getIncomings().clear();
				getIncomings().addAll((Collection) newValue);
				return;
			case UMLPackage.ACTION__IN_PARTITION :
				getInPartitions().clear();
				getInPartitions().addAll((Collection) newValue);
				return;
			case UMLPackage.ACTION__IN_INTERRUPTIBLE_REGION :
				getInInterruptibleRegions().clear();
				getInInterruptibleRegions().addAll((Collection) newValue);
				return;
			case UMLPackage.ACTION__REDEFINED_NODE :
				getRedefinedNodes().clear();
				getRedefinedNodes().addAll((Collection) newValue);
				return;
			case UMLPackage.ACTION__HANDLER :
				getHandlers().clear();
				getHandlers().addAll((Collection) newValue);
				return;
			case UMLPackage.ACTION__LOCAL_PRECONDITION :
				getLocalPreconditions().clear();
				getLocalPreconditions().addAll((Collection) newValue);
				return;
			case UMLPackage.ACTION__LOCAL_POSTCONDITION :
				getLocalPostconditions().clear();
				getLocalPostconditions().addAll((Collection) newValue);
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
			case UMLPackage.ACTION__EANNOTATIONS :
				getEAnnotations().clear();
				return;
			case UMLPackage.ACTION__OWNED_COMMENT :
				getOwnedComments().clear();
				return;
			case UMLPackage.ACTION__NAME :
				unsetName();
				return;
			case UMLPackage.ACTION__VISIBILITY :
				unsetVisibility();
				return;
			case UMLPackage.ACTION__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				return;
			case UMLPackage.ACTION__NAME_EXPRESSION :
				setNameExpression((StringExpression) null);
				return;
			case UMLPackage.ACTION__IS_LEAF :
				setIsLeaf(IS_LEAF_EDEFAULT);
				return;
			case UMLPackage.ACTION__IN_STRUCTURED_NODE :
				setInStructuredNode((StructuredActivityNode) null);
				return;
			case UMLPackage.ACTION__ACTIVITY :
				setActivity((Activity) null);
				return;
			case UMLPackage.ACTION__OUTGOING :
				getOutgoings().clear();
				return;
			case UMLPackage.ACTION__INCOMING :
				getIncomings().clear();
				return;
			case UMLPackage.ACTION__IN_PARTITION :
				getInPartitions().clear();
				return;
			case UMLPackage.ACTION__IN_INTERRUPTIBLE_REGION :
				getInInterruptibleRegions().clear();
				return;
			case UMLPackage.ACTION__REDEFINED_NODE :
				getRedefinedNodes().clear();
				return;
			case UMLPackage.ACTION__HANDLER :
				getHandlers().clear();
				return;
			case UMLPackage.ACTION__LOCAL_PRECONDITION :
				getLocalPreconditions().clear();
				return;
			case UMLPackage.ACTION__LOCAL_POSTCONDITION :
				getLocalPostconditions().clear();
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
			case UMLPackage.ACTION__EANNOTATIONS :
				EList eAnnotations = (EList) eVirtualGet(UMLPackage.ACTION__EANNOTATIONS);
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UMLPackage.ACTION__OWNED_ELEMENT :
				return isSetOwnedElements();
			case UMLPackage.ACTION__OWNER :
				return isSetOwner();
			case UMLPackage.ACTION__OWNED_COMMENT :
				EList ownedComment = (EList) eVirtualGet(UMLPackage.ACTION__OWNED_COMMENT);
				return ownedComment != null && !ownedComment.isEmpty();
			case UMLPackage.ACTION__NAME :
				return isSetName();
			case UMLPackage.ACTION__VISIBILITY :
				return isSetVisibility();
			case UMLPackage.ACTION__QUALIFIED_NAME :
				return QUALIFIED_NAME_EDEFAULT == null
					? getQualifiedName() != null
					: !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UMLPackage.ACTION__CLIENT_DEPENDENCY :
				EList clientDependency = (EList) eVirtualGet(UMLPackage.ACTION__CLIENT_DEPENDENCY);
				return clientDependency != null && !clientDependency.isEmpty();
			case UMLPackage.ACTION__NAMESPACE :
				return isSetNamespace();
			case UMLPackage.ACTION__NAME_EXPRESSION :
				return eVirtualGet(UMLPackage.ACTION__NAME_EXPRESSION) != null;
			case UMLPackage.ACTION__IS_LEAF :
				return ((eFlags & IS_LEAF_EFLAG) != 0) != IS_LEAF_EDEFAULT;
			case UMLPackage.ACTION__REDEFINED_ELEMENT :
				return isSetRedefinedElements();
			case UMLPackage.ACTION__REDEFINITION_CONTEXT :
				return isSetRedefinitionContexts();
			case UMLPackage.ACTION__IN_STRUCTURED_NODE :
				return getInStructuredNode() != null;
			case UMLPackage.ACTION__ACTIVITY :
				return getActivity() != null;
			case UMLPackage.ACTION__OUTGOING :
				EList outgoing = (EList) eVirtualGet(UMLPackage.ACTION__OUTGOING);
				return outgoing != null && !outgoing.isEmpty();
			case UMLPackage.ACTION__INCOMING :
				EList incoming = (EList) eVirtualGet(UMLPackage.ACTION__INCOMING);
				return incoming != null && !incoming.isEmpty();
			case UMLPackage.ACTION__IN_PARTITION :
				EList inPartition = (EList) eVirtualGet(UMLPackage.ACTION__IN_PARTITION);
				return inPartition != null && !inPartition.isEmpty();
			case UMLPackage.ACTION__IN_INTERRUPTIBLE_REGION :
				EList inInterruptibleRegion = (EList) eVirtualGet(UMLPackage.ACTION__IN_INTERRUPTIBLE_REGION);
				return inInterruptibleRegion != null
					&& !inInterruptibleRegion.isEmpty();
			case UMLPackage.ACTION__IN_GROUP :
				return isSetInGroups();
			case UMLPackage.ACTION__REDEFINED_NODE :
				EList redefinedNode = (EList) eVirtualGet(UMLPackage.ACTION__REDEFINED_NODE);
				return redefinedNode != null && !redefinedNode.isEmpty();
			case UMLPackage.ACTION__HANDLER :
				EList handler = (EList) eVirtualGet(UMLPackage.ACTION__HANDLER);
				return handler != null && !handler.isEmpty();
			case UMLPackage.ACTION__OUTPUT :
				return isSetOutputs();
			case UMLPackage.ACTION__INPUT :
				return isSetInputs();
			case UMLPackage.ACTION__CONTEXT :
				return getContext() != null;
			case UMLPackage.ACTION__LOCAL_PRECONDITION :
				EList localPrecondition = (EList) eVirtualGet(UMLPackage.ACTION__LOCAL_PRECONDITION);
				return localPrecondition != null
					&& !localPrecondition.isEmpty();
			case UMLPackage.ACTION__LOCAL_POSTCONDITION :
				EList localPostcondition = (EList) eVirtualGet(UMLPackage.ACTION__LOCAL_POSTCONDITION);
				return localPostcondition != null
					&& !localPostcondition.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOutputs() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedElements() {
		return super.isSetOwnedElements() || isSetOutputs() || isSetInputs()
			|| eIsSet(UMLPackage.ACTION__LOCAL_PRECONDITION)
			|| eIsSet(UMLPackage.ACTION__LOCAL_POSTCONDITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInputs() {
		return false;
	}

} //ActionImpl
