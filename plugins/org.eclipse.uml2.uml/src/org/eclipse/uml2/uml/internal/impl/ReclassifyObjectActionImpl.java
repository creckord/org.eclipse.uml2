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
 * $Id: ReclassifyObjectActionImpl.java,v 1.5 2005/11/28 20:26:02 khussey Exp $
 */
package org.eclipse.uml2.uml.internal.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.ReclassifyObjectAction;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

import org.eclipse.uml2.uml.internal.operations.ReclassifyObjectActionOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reclassify Object Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.ReclassifyObjectActionImpl#getInputs <em>Input</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.ReclassifyObjectActionImpl#isReplaceAll <em>Is Replace All</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.ReclassifyObjectActionImpl#getOldClassifiers <em>Old Classifier</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.ReclassifyObjectActionImpl#getNewClassifiers <em>New Classifier</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.ReclassifyObjectActionImpl#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReclassifyObjectActionImpl
		extends ActionImpl
		implements ReclassifyObjectAction {

	/**
	 * The default value of the '{@link #isReplaceAll() <em>Is Replace All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReplaceAll()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_REPLACE_ALL_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isReplaceAll() <em>Is Replace All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReplaceAll()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_REPLACE_ALL_EFLAG = 1 << 9;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReclassifyObjectActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UMLPackage.Literals.RECLASSIFY_OBJECT_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getInputs() {
		List input = (List) eVirtualGet(UMLPackage.RECLASSIFY_OBJECT_ACTION__INPUT);
		if (input == null) {
			eVirtualSet(UMLPackage.RECLASSIFY_OBJECT_ACTION__INPUT,
				input = new DerivedUnionEObjectEList(InputPin.class, this,
					UMLPackage.RECLASSIFY_OBJECT_ACTION__INPUT,
					new int[]{UMLPackage.RECLASSIFY_OBJECT_ACTION__OBJECT}));
		}
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReplaceAll() {
		return (eFlags & IS_REPLACE_ALL_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsReplaceAll(boolean newIsReplaceAll) {
		boolean oldIsReplaceAll = (eFlags & IS_REPLACE_ALL_EFLAG) != 0;
		if (newIsReplaceAll)
			eFlags |= IS_REPLACE_ALL_EFLAG;
		else
			eFlags &= ~IS_REPLACE_ALL_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.RECLASSIFY_OBJECT_ACTION__IS_REPLACE_ALL,
				oldIsReplaceAll, newIsReplaceAll));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getOldClassifiers() {
		List oldClassifier = (List) eVirtualGet(UMLPackage.RECLASSIFY_OBJECT_ACTION__OLD_CLASSIFIER);
		if (oldClassifier == null) {
			eVirtualSet(UMLPackage.RECLASSIFY_OBJECT_ACTION__OLD_CLASSIFIER,
				oldClassifier = new EObjectResolvingEList(Classifier.class,
					this, UMLPackage.RECLASSIFY_OBJECT_ACTION__OLD_CLASSIFIER));
		}
		return oldClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier getOldClassifier(String name) {
		for (Iterator i = getOldClassifiers().iterator(); i.hasNext();) {
			Classifier oldClassifier = (Classifier) i.next();
			if (name.equals(oldClassifier.getName())) {
				return oldClassifier;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getNewClassifiers() {
		List newClassifier = (List) eVirtualGet(UMLPackage.RECLASSIFY_OBJECT_ACTION__NEW_CLASSIFIER);
		if (newClassifier == null) {
			eVirtualSet(UMLPackage.RECLASSIFY_OBJECT_ACTION__NEW_CLASSIFIER,
				newClassifier = new EObjectResolvingEList(Classifier.class,
					this, UMLPackage.RECLASSIFY_OBJECT_ACTION__NEW_CLASSIFIER));
		}
		return newClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier getNewClassifier(String name) {
		for (Iterator i = getNewClassifiers().iterator(); i.hasNext();) {
			Classifier newClassifier = (Classifier) i.next();
			if (name.equals(newClassifier.getName())) {
				return newClassifier;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPin getObject() {
		return (InputPin) eVirtualGet(UMLPackage.RECLASSIFY_OBJECT_ACTION__OBJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObject(InputPin newObject,
			NotificationChain msgs) {
		Object oldObject = eVirtualSet(
			UMLPackage.RECLASSIFY_OBJECT_ACTION__OBJECT, newObject);
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET, UMLPackage.RECLASSIFY_OBJECT_ACTION__OBJECT,
				oldObject == EVIRTUAL_NO_VALUE
					? null
					: oldObject, newObject);
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
	public void setObject(InputPin newObject) {
		InputPin object = (InputPin) eVirtualGet(UMLPackage.RECLASSIFY_OBJECT_ACTION__OBJECT);
		if (newObject != object) {
			NotificationChain msgs = null;
			if (object != null)
				msgs = ((InternalEObject) object).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- UMLPackage.RECLASSIFY_OBJECT_ACTION__OBJECT, null,
					msgs);
			if (newObject != null)
				msgs = ((InternalEObject) newObject).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- UMLPackage.RECLASSIFY_OBJECT_ACTION__OBJECT, null,
					msgs);
			msgs = basicSetObject(newObject, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.RECLASSIFY_OBJECT_ACTION__OBJECT, newObject,
				newObject));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPin createObject(EClass eClass) {
		InputPin newObject = (InputPin) eClass.getEPackage()
			.getEFactoryInstance().create(eClass);
		setObject(newObject);
		return newObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPin createObject() {
		InputPin newObject = UMLFactory.eINSTANCE.createInputPin();
		setObject(newObject);
		return newObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifierNotAbstract(DiagnosticChain diagnostics,
			Map context) {
		return ReclassifyObjectActionOperations.validateClassifierNotAbstract(
			this, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiplicity(DiagnosticChain diagnostics, Map context) {
		return ReclassifyObjectActionOperations.validateMultiplicity(this,
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInputPin(DiagnosticChain diagnostics, Map context) {
		return ReclassifyObjectActionOperations.validateInputPin(this,
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
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__EANNOTATIONS :
				return ((InternalEList) getEAnnotations()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OWNED_COMMENT :
				return ((InternalEList) getOwnedComments()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__CLIENT_DEPENDENCY :
				return ((InternalEList) getClientDependencies()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__NAME_EXPRESSION :
				return basicSetNameExpression(null, msgs);
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OUTGOING :
				return ((InternalEList) getOutgoings()).basicRemove(otherEnd,
					msgs);
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IN_PARTITION :
				return ((InternalEList) getInPartitions()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IN_STRUCTURED_NODE :
				return eBasicSetContainer(null,
					UMLPackage.RECLASSIFY_OBJECT_ACTION__IN_STRUCTURED_NODE,
					msgs);
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__ACTIVITY :
				return eBasicSetContainer(null,
					UMLPackage.RECLASSIFY_OBJECT_ACTION__ACTIVITY, msgs);
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__INCOMING :
				return ((InternalEList) getIncomings()).basicRemove(otherEnd,
					msgs);
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IN_INTERRUPTIBLE_REGION :
				return ((InternalEList) getInInterruptibleRegions())
					.basicRemove(otherEnd, msgs);
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__HANDLER :
				return ((InternalEList) getHandlers()).basicRemove(otherEnd,
					msgs);
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__LOCAL_PRECONDITION :
				return ((InternalEList) getLocalPreconditions()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__LOCAL_POSTCONDITION :
				return ((InternalEList) getLocalPostconditions()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OBJECT :
				return basicSetObject(null, msgs);
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
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__EANNOTATIONS :
				return getEAnnotations();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OWNED_ELEMENT :
				return getOwnedElements();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OWNER :
				return getOwner();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OWNED_COMMENT :
				return getOwnedComments();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__NAME :
				return getName();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__VISIBILITY :
				return getVisibility();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__QUALIFIED_NAME :
				return getQualifiedName();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__CLIENT_DEPENDENCY :
				return getClientDependencies();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__NAMESPACE :
				if (resolve)
					return getNamespace();
				return basicGetNamespace();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__NAME_EXPRESSION :
				return getNameExpression();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IS_LEAF :
				return isLeaf()
					? Boolean.TRUE
					: Boolean.FALSE;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__REDEFINED_ELEMENT :
				return getRedefinedElements();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__REDEFINITION_CONTEXT :
				return getRedefinitionContexts();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OUTGOING :
				return getOutgoings();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IN_GROUP :
				return getInGroups();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IN_PARTITION :
				return getInPartitions();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IN_STRUCTURED_NODE :
				return getInStructuredNode();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__ACTIVITY :
				return getActivity();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__INCOMING :
				return getIncomings();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IN_INTERRUPTIBLE_REGION :
				return getInInterruptibleRegions();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__REDEFINED_NODE :
				return getRedefinedNodes();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__HANDLER :
				return getHandlers();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OUTPUT :
				return getOutputs();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__INPUT :
				return getInputs();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__CONTEXT :
				return getContext();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__LOCAL_PRECONDITION :
				return getLocalPreconditions();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__LOCAL_POSTCONDITION :
				return getLocalPostconditions();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IS_REPLACE_ALL :
				return isReplaceAll()
					? Boolean.TRUE
					: Boolean.FALSE;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OLD_CLASSIFIER :
				return getOldClassifiers();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__NEW_CLASSIFIER :
				return getNewClassifiers();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OBJECT :
				return getObject();
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
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__EANNOTATIONS :
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection) newValue);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OWNED_COMMENT :
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection) newValue);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__NAME :
				setName((String) newValue);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__VISIBILITY :
				setVisibility((VisibilityKind) newValue);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection) newValue);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__NAME_EXPRESSION :
				setNameExpression((StringExpression) newValue);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IS_LEAF :
				setIsLeaf(((Boolean) newValue).booleanValue());
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OUTGOING :
				getOutgoings().clear();
				getOutgoings().addAll((Collection) newValue);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IN_PARTITION :
				getInPartitions().clear();
				getInPartitions().addAll((Collection) newValue);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IN_STRUCTURED_NODE :
				setInStructuredNode((StructuredActivityNode) newValue);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__ACTIVITY :
				setActivity((Activity) newValue);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__INCOMING :
				getIncomings().clear();
				getIncomings().addAll((Collection) newValue);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IN_INTERRUPTIBLE_REGION :
				getInInterruptibleRegions().clear();
				getInInterruptibleRegions().addAll((Collection) newValue);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__REDEFINED_NODE :
				getRedefinedNodes().clear();
				getRedefinedNodes().addAll((Collection) newValue);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__HANDLER :
				getHandlers().clear();
				getHandlers().addAll((Collection) newValue);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__LOCAL_PRECONDITION :
				getLocalPreconditions().clear();
				getLocalPreconditions().addAll((Collection) newValue);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__LOCAL_POSTCONDITION :
				getLocalPostconditions().clear();
				getLocalPostconditions().addAll((Collection) newValue);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IS_REPLACE_ALL :
				setIsReplaceAll(((Boolean) newValue).booleanValue());
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OLD_CLASSIFIER :
				getOldClassifiers().clear();
				getOldClassifiers().addAll((Collection) newValue);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__NEW_CLASSIFIER :
				getNewClassifiers().clear();
				getNewClassifiers().addAll((Collection) newValue);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OBJECT :
				setObject((InputPin) newValue);
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
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__EANNOTATIONS :
				getEAnnotations().clear();
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OWNED_COMMENT :
				getOwnedComments().clear();
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__NAME :
				setName(NAME_EDEFAULT);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__VISIBILITY :
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__NAME_EXPRESSION :
				setNameExpression((StringExpression) null);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IS_LEAF :
				setIsLeaf(IS_LEAF_EDEFAULT);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OUTGOING :
				getOutgoings().clear();
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IN_PARTITION :
				getInPartitions().clear();
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IN_STRUCTURED_NODE :
				setInStructuredNode((StructuredActivityNode) null);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__ACTIVITY :
				setActivity((Activity) null);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__INCOMING :
				getIncomings().clear();
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IN_INTERRUPTIBLE_REGION :
				getInInterruptibleRegions().clear();
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__REDEFINED_NODE :
				getRedefinedNodes().clear();
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__HANDLER :
				getHandlers().clear();
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__LOCAL_PRECONDITION :
				getLocalPreconditions().clear();
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__LOCAL_POSTCONDITION :
				getLocalPostconditions().clear();
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IS_REPLACE_ALL :
				setIsReplaceAll(IS_REPLACE_ALL_EDEFAULT);
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OLD_CLASSIFIER :
				getOldClassifiers().clear();
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__NEW_CLASSIFIER :
				getNewClassifiers().clear();
				return;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OBJECT :
				setObject((InputPin) null);
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
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__EANNOTATIONS :
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OWNED_ELEMENT :
				return isSetOwnedElements();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OWNER :
				return isSetOwner();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OWNED_COMMENT :
				List ownedComment = (List) eVirtualGet(UMLPackage.RECLASSIFY_OBJECT_ACTION__OWNED_COMMENT);
				return ownedComment != null && !ownedComment.isEmpty();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__NAME :
				String name = (String) eVirtualGet(
					UMLPackage.RECLASSIFY_OBJECT_ACTION__NAME, NAME_EDEFAULT);
				return NAME_EDEFAULT == null
					? name != null
					: !NAME_EDEFAULT.equals(name);
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__VISIBILITY :
				return eVirtualGet(
					UMLPackage.RECLASSIFY_OBJECT_ACTION__VISIBILITY,
					VISIBILITY_EDEFAULT) != VISIBILITY_EDEFAULT;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__QUALIFIED_NAME :
				return QUALIFIED_NAME_EDEFAULT == null
					? getQualifiedName() != null
					: !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__CLIENT_DEPENDENCY :
				List clientDependency = (List) eVirtualGet(UMLPackage.RECLASSIFY_OBJECT_ACTION__CLIENT_DEPENDENCY);
				return clientDependency != null && !clientDependency.isEmpty();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__NAMESPACE :
				return isSetNamespace();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__NAME_EXPRESSION :
				return eVirtualGet(UMLPackage.RECLASSIFY_OBJECT_ACTION__NAME_EXPRESSION) != null;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IS_LEAF :
				return ((eFlags & IS_LEAF_EFLAG) != 0) != IS_LEAF_EDEFAULT;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__REDEFINED_ELEMENT :
				return isSetRedefinedElements();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__REDEFINITION_CONTEXT :
				return isSetRedefinitionContexts();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OUTGOING :
				List outgoing = (List) eVirtualGet(UMLPackage.RECLASSIFY_OBJECT_ACTION__OUTGOING);
				return outgoing != null && !outgoing.isEmpty();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IN_GROUP :
				return isSetInGroups();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IN_PARTITION :
				List inPartition = (List) eVirtualGet(UMLPackage.RECLASSIFY_OBJECT_ACTION__IN_PARTITION);
				return inPartition != null && !inPartition.isEmpty();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IN_STRUCTURED_NODE :
				return getInStructuredNode() != null;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__ACTIVITY :
				return getActivity() != null;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__INCOMING :
				List incoming = (List) eVirtualGet(UMLPackage.RECLASSIFY_OBJECT_ACTION__INCOMING);
				return incoming != null && !incoming.isEmpty();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IN_INTERRUPTIBLE_REGION :
				List inInterruptibleRegion = (List) eVirtualGet(UMLPackage.RECLASSIFY_OBJECT_ACTION__IN_INTERRUPTIBLE_REGION);
				return inInterruptibleRegion != null
					&& !inInterruptibleRegion.isEmpty();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__REDEFINED_NODE :
				List redefinedNode = (List) eVirtualGet(UMLPackage.RECLASSIFY_OBJECT_ACTION__REDEFINED_NODE);
				return redefinedNode != null && !redefinedNode.isEmpty();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__HANDLER :
				List handler = (List) eVirtualGet(UMLPackage.RECLASSIFY_OBJECT_ACTION__HANDLER);
				return handler != null && !handler.isEmpty();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OUTPUT :
				return isSetOutputs();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__INPUT :
				return isSetInputs();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__CONTEXT :
				return getContext() != null;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__LOCAL_PRECONDITION :
				List localPrecondition = (List) eVirtualGet(UMLPackage.RECLASSIFY_OBJECT_ACTION__LOCAL_PRECONDITION);
				return localPrecondition != null
					&& !localPrecondition.isEmpty();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__LOCAL_POSTCONDITION :
				List localPostcondition = (List) eVirtualGet(UMLPackage.RECLASSIFY_OBJECT_ACTION__LOCAL_POSTCONDITION);
				return localPostcondition != null
					&& !localPostcondition.isEmpty();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__IS_REPLACE_ALL :
				return ((eFlags & IS_REPLACE_ALL_EFLAG) != 0) != IS_REPLACE_ALL_EDEFAULT;
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OLD_CLASSIFIER :
				List oldClassifier = (List) eVirtualGet(UMLPackage.RECLASSIFY_OBJECT_ACTION__OLD_CLASSIFIER);
				return oldClassifier != null && !oldClassifier.isEmpty();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__NEW_CLASSIFIER :
				List newClassifier = (List) eVirtualGet(UMLPackage.RECLASSIFY_OBJECT_ACTION__NEW_CLASSIFIER);
				return newClassifier != null && !newClassifier.isEmpty();
			case UMLPackage.RECLASSIFY_OBJECT_ACTION__OBJECT :
				return eVirtualGet(UMLPackage.RECLASSIFY_OBJECT_ACTION__OBJECT) != null;
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
		result.append(" (isReplaceAll: "); //$NON-NLS-1$
		result.append((eFlags & IS_REPLACE_ALL_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInputs() {
		return super.isSetInputs()
			|| eIsSet(UMLPackage.RECLASSIFY_OBJECT_ACTION__OBJECT);
	}

} //ReclassifyObjectActionImpl