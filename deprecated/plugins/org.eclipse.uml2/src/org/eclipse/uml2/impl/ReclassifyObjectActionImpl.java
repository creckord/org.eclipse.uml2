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
 * $Id: ReclassifyObjectActionImpl.java,v 1.25 2006/05/26 18:16:44 khussey Exp $
 */
package org.eclipse.uml2.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.Activity;
import org.eclipse.uml2.Classifier;
import org.eclipse.uml2.InputPin;
import org.eclipse.uml2.ReclassifyObjectAction;
import org.eclipse.uml2.StringExpression;
import org.eclipse.uml2.StructuredActivityNode;
import org.eclipse.uml2.TemplateSignature;
import org.eclipse.uml2.UML2Factory;
import org.eclipse.uml2.UML2Package;
import org.eclipse.uml2.VisibilityKind;

import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reclassify Object Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.impl.ReclassifyObjectActionImpl#getInputs <em>Input</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.ReclassifyObjectActionImpl#isReplaceAll <em>Is Replace All</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.ReclassifyObjectActionImpl#getOldClassifiers <em>Old Classifier</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.ReclassifyObjectActionImpl#getNewClassifiers <em>New Classifier</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.ReclassifyObjectActionImpl#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReclassifyObjectActionImpl extends ActionImpl implements ReclassifyObjectAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) IBM Corporation and others."; //$NON-NLS-1$

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
	 * The cached value of the '{@link #getOldClassifiers() <em>Old Classifier</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldClassifiers()
	 * @generated
	 * @ordered
	 */
	protected EList oldClassifiers = null;

	/**
	 * The cached value of the '{@link #getNewClassifiers() <em>New Classifier</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewClassifiers()
	 * @generated
	 * @ordered
	 */
	protected EList newClassifiers = null;

	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected InputPin object = null;

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
		return UML2Package.Literals.RECLASSIFY_OBJECT_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getInputs() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			EList inputs = (EList) cache.get(eResource, this, UML2Package.Literals.ACTION__INPUT);
			if (inputs == null) {
				cache.put(eResource, this, UML2Package.Literals.ACTION__INPUT, inputs = new DerivedUnionEObjectEList(InputPin.class, this, UML2Package.RECLASSIFY_OBJECT_ACTION__INPUT, INPUT_ESUBSETS));
			}
			return inputs;
		}
		return new DerivedUnionEObjectEList(InputPin.class, this, UML2Package.RECLASSIFY_OBJECT_ACTION__INPUT, INPUT_ESUBSETS);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInputs() {
		return super.isSetInputs()
			|| eIsSet(UML2Package.RECLASSIFY_OBJECT_ACTION__OBJECT);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getInputs() <em>Input</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected static final int[] INPUT_ESUBSETS = new int[] {UML2Package.RECLASSIFY_OBJECT_ACTION__OBJECT};

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
		if (newIsReplaceAll) eFlags |= IS_REPLACE_ALL_EFLAG; else eFlags &= ~IS_REPLACE_ALL_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2Package.RECLASSIFY_OBJECT_ACTION__IS_REPLACE_ALL, oldIsReplaceAll, newIsReplaceAll));


	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getOldClassifiers() {
		if (oldClassifiers == null) {
			oldClassifiers = new EObjectResolvingEList(Classifier.class, this, UML2Package.RECLASSIFY_OBJECT_ACTION__OLD_CLASSIFIER);
		}
		return oldClassifiers;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
    public Classifier getOldClassifier(String name) {
		return getOldClassifier(name, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier getOldClassifier(String name, boolean ignoreCase, EClass eClass) {
		oldClassifierLoop: for (Iterator i = getOldClassifiers().iterator(); i.hasNext(); ) {
			Classifier oldClassifier = (Classifier) i.next();
			if (eClass != null && !eClass.isInstance(oldClassifier))
				continue oldClassifierLoop;
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(oldClassifier.getName()) : name.equals(oldClassifier.getName())))
				continue oldClassifierLoop;
			return oldClassifier;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getNewClassifiers() {
		if (newClassifiers == null) {
			newClassifiers = new EObjectResolvingEList(Classifier.class, this, UML2Package.RECLASSIFY_OBJECT_ACTION__NEW_CLASSIFIER);
		}
		return newClassifiers;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
    public Classifier getNewClassifier(String name) {
		return getNewClassifier(name, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier getNewClassifier(String name, boolean ignoreCase, EClass eClass) {
		newClassifierLoop: for (Iterator i = getNewClassifiers().iterator(); i.hasNext(); ) {
			Classifier newClassifier = (Classifier) i.next();
			if (eClass != null && !eClass.isInstance(newClassifier))
				continue newClassifierLoop;
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(newClassifier.getName()) : name.equals(newClassifier.getName())))
				continue newClassifierLoop;
			return newClassifier;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPin getObject() {
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObject(InputPin newObject, NotificationChain msgs) {
		InputPin oldObject = object;
		object = newObject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UML2Package.RECLASSIFY_OBJECT_ACTION__OBJECT, oldObject, newObject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}

		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObject(InputPin newObject) {
		if (newObject != object) {
			NotificationChain msgs = null;
			if (object != null)
				msgs = ((InternalEObject)object).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UML2Package.RECLASSIFY_OBJECT_ACTION__OBJECT, null, msgs);
			if (newObject != null)
				msgs = ((InternalEObject)newObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UML2Package.RECLASSIFY_OBJECT_ACTION__OBJECT, null, msgs);
			msgs = basicSetObject(newObject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2Package.RECLASSIFY_OBJECT_ACTION__OBJECT, newObject, newObject));

	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public InputPin createObject(EClass eClass) {
		InputPin newObject = (InputPin) eClass.getEPackage().getEFactoryInstance().create(eClass);
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, 0, UML2Package.RECLASSIFY_OBJECT_ACTION__OBJECT, null, newObject));
		}
		setObject(newObject);
		return newObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public InputPin createObject() {
		InputPin newObject = UML2Factory.eINSTANCE.createInputPin();
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, 0, UML2Package.RECLASSIFY_OBJECT_ACTION__OBJECT, null, newObject));
		}
		setObject(newObject);
		return newObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UML2Package.RECLASSIFY_OBJECT_ACTION__EANNOTATIONS:
				return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OWNED_COMMENT:
				return ((InternalEList)getOwnedComments()).basicRemove(otherEnd, msgs);
			case UML2Package.RECLASSIFY_OBJECT_ACTION__TEMPLATE_BINDING:
				return ((InternalEList)getTemplateBindings()).basicRemove(otherEnd, msgs);
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OWNED_TEMPLATE_SIGNATURE:
				return basicSetOwnedTemplateSignature(null, msgs);
			case UML2Package.RECLASSIFY_OBJECT_ACTION__CLIENT_DEPENDENCY:
				return ((InternalEList)getClientDependencies()).basicRemove(otherEnd, msgs);
			case UML2Package.RECLASSIFY_OBJECT_ACTION__NAME_EXPRESSION:
				return basicSetNameExpression(null, msgs);
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OUTGOING:
				return ((InternalEList)getOutgoings()).basicRemove(otherEnd, msgs);
			case UML2Package.RECLASSIFY_OBJECT_ACTION__INCOMING:
				return ((InternalEList)getIncomings()).basicRemove(otherEnd, msgs);
			case UML2Package.RECLASSIFY_OBJECT_ACTION__ACTIVITY:
				return basicSetActivity(null, msgs);
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IN_STRUCTURED_NODE:
				return basicSetInStructuredNode(null, msgs);
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IN_PARTITION:
				return ((InternalEList)getInPartitions()).basicRemove(otherEnd, msgs);
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IN_INTERRUPTIBLE_REGION:
				return ((InternalEList)getInInterruptibleRegions()).basicRemove(otherEnd, msgs);
			case UML2Package.RECLASSIFY_OBJECT_ACTION__HANDLER:
				return ((InternalEList)getHandlers()).basicRemove(otherEnd, msgs);
			case UML2Package.RECLASSIFY_OBJECT_ACTION__LOCAL_PRECONDITION:
				return ((InternalEList)getLocalPreconditions()).basicRemove(otherEnd, msgs);
			case UML2Package.RECLASSIFY_OBJECT_ACTION__LOCAL_POSTCONDITION:
				return ((InternalEList)getLocalPostconditions()).basicRemove(otherEnd, msgs);
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OBJECT:
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
			case UML2Package.RECLASSIFY_OBJECT_ACTION__EANNOTATIONS:
				return getEAnnotations();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OWNED_ELEMENT:
				return getOwnedElements();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OWNED_COMMENT:
				return getOwnedComments();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__TEMPLATE_BINDING:
				return getTemplateBindings();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__NAME:
				return getName();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__QUALIFIED_NAME:
				return getQualifiedName();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__VISIBILITY:
				return getVisibility();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__CLIENT_DEPENDENCY:
				return getClientDependencies();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__NAME_EXPRESSION:
				return getNameExpression();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__REDEFINITION_CONTEXT:
				return getRedefinitionContexts();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IS_LEAF:
				return isLeaf() ? Boolean.TRUE : Boolean.FALSE;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OUTGOING:
				return getOutgoings();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__INCOMING:
				return getIncomings();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IN_GROUP:
				return getInGroups();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__ACTIVITY:
				return getActivity();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__REDEFINED_ELEMENT:
				return getRedefinedElements();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IN_STRUCTURED_NODE:
				return getInStructuredNode();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IN_PARTITION:
				return getInPartitions();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IN_INTERRUPTIBLE_REGION:
				return getInInterruptibleRegions();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__HANDLER:
				return getHandlers();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__EFFECT:
				return getEffect();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OUTPUT:
				return getOutputs();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__INPUT:
				return getInputs();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__CONTEXT:
				return getContext();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__LOCAL_PRECONDITION:
				return getLocalPreconditions();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__LOCAL_POSTCONDITION:
				return getLocalPostconditions();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IS_REPLACE_ALL:
				return isReplaceAll() ? Boolean.TRUE : Boolean.FALSE;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OLD_CLASSIFIER:
				return getOldClassifiers();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__NEW_CLASSIFIER:
				return getNewClassifiers();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OBJECT:
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
			case UML2Package.RECLASSIFY_OBJECT_ACTION__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection)newValue);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection)newValue);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__NAME:
				setName((String)newValue);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__VISIBILITY:
				setVisibility((VisibilityKind)newValue);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection)newValue);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__NAME_EXPRESSION:
				setNameExpression((StringExpression)newValue);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IS_LEAF:
				setIsLeaf(((Boolean)newValue).booleanValue());
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OUTGOING:
				getOutgoings().clear();
				getOutgoings().addAll((Collection)newValue);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__INCOMING:
				getIncomings().clear();
				getIncomings().addAll((Collection)newValue);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__ACTIVITY:
				setActivity((Activity)newValue);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__REDEFINED_ELEMENT:
				getRedefinedElements().clear();
				getRedefinedElements().addAll((Collection)newValue);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IN_STRUCTURED_NODE:
				setInStructuredNode((StructuredActivityNode)newValue);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IN_PARTITION:
				getInPartitions().clear();
				getInPartitions().addAll((Collection)newValue);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IN_INTERRUPTIBLE_REGION:
				getInInterruptibleRegions().clear();
				getInInterruptibleRegions().addAll((Collection)newValue);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__HANDLER:
				getHandlers().clear();
				getHandlers().addAll((Collection)newValue);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__EFFECT:
				setEffect((String)newValue);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__LOCAL_PRECONDITION:
				getLocalPreconditions().clear();
				getLocalPreconditions().addAll((Collection)newValue);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__LOCAL_POSTCONDITION:
				getLocalPostconditions().clear();
				getLocalPostconditions().addAll((Collection)newValue);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IS_REPLACE_ALL:
				setIsReplaceAll(((Boolean)newValue).booleanValue());
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OLD_CLASSIFIER:
				getOldClassifiers().clear();
				getOldClassifiers().addAll((Collection)newValue);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__NEW_CLASSIFIER:
				getNewClassifiers().clear();
				getNewClassifiers().addAll((Collection)newValue);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OBJECT:
				setObject((InputPin)newValue);
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
			case UML2Package.RECLASSIFY_OBJECT_ACTION__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__NAME_EXPRESSION:
				setNameExpression((StringExpression)null);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IS_LEAF:
				setIsLeaf(IS_LEAF_EDEFAULT);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OUTGOING:
				getOutgoings().clear();
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__INCOMING:
				getIncomings().clear();
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__ACTIVITY:
				setActivity((Activity)null);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__REDEFINED_ELEMENT:
				getRedefinedElements().clear();
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IN_STRUCTURED_NODE:
				setInStructuredNode((StructuredActivityNode)null);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IN_PARTITION:
				getInPartitions().clear();
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IN_INTERRUPTIBLE_REGION:
				getInInterruptibleRegions().clear();
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__HANDLER:
				getHandlers().clear();
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__EFFECT:
				setEffect(EFFECT_EDEFAULT);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__LOCAL_PRECONDITION:
				getLocalPreconditions().clear();
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__LOCAL_POSTCONDITION:
				getLocalPostconditions().clear();
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IS_REPLACE_ALL:
				setIsReplaceAll(IS_REPLACE_ALL_EDEFAULT);
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OLD_CLASSIFIER:
				getOldClassifiers().clear();
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__NEW_CLASSIFIER:
				getNewClassifiers().clear();
				return;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OBJECT:
				setObject((InputPin)null);
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
			case UML2Package.RECLASSIFY_OBJECT_ACTION__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OWNED_ELEMENT:
				return isSetOwnedElements();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OWNER:
				return isSetOwner();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__TEMPLATE_BINDING:
				return templateBindings != null && !templateBindings.isEmpty();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UML2Package.RECLASSIFY_OBJECT_ACTION__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? getQualifiedName() != null : !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UML2Package.RECLASSIFY_OBJECT_ACTION__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__CLIENT_DEPENDENCY:
				return clientDependencies != null && !clientDependencies.isEmpty();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__NAME_EXPRESSION:
				return nameExpression != null;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__REDEFINITION_CONTEXT:
				return isSetRedefinitionContexts();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IS_LEAF:
				return ((eFlags & IS_LEAF_EFLAG) != 0) != IS_LEAF_EDEFAULT;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OUTGOING:
				return outgoings != null && !outgoings.isEmpty();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__INCOMING:
				return incomings != null && !incomings.isEmpty();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IN_GROUP:
				return isSetInGroups();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__ACTIVITY:
				return getActivity() != null;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__REDEFINED_ELEMENT:
				return isSetRedefinedElements();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IN_STRUCTURED_NODE:
				return getInStructuredNode() != null;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IN_PARTITION:
				return inPartitions != null && !inPartitions.isEmpty();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IN_INTERRUPTIBLE_REGION:
				return inInterruptibleRegions != null && !inInterruptibleRegions.isEmpty();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__HANDLER:
				return handlers != null && !handlers.isEmpty();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__EFFECT:
				return EFFECT_EDEFAULT == null ? effect != null : !EFFECT_EDEFAULT.equals(effect);
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OUTPUT:
				return isSetOutputs();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__INPUT:
				return isSetInputs();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__CONTEXT:
				return getContext() != null;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__LOCAL_PRECONDITION:
				return localPreconditions != null && !localPreconditions.isEmpty();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__LOCAL_POSTCONDITION:
				return localPostconditions != null && !localPostconditions.isEmpty();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__IS_REPLACE_ALL:
				return ((eFlags & IS_REPLACE_ALL_EFLAG) != 0) != IS_REPLACE_ALL_EDEFAULT;
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OLD_CLASSIFIER:
				return oldClassifiers != null && !oldClassifiers.isEmpty();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__NEW_CLASSIFIER:
				return newClassifiers != null && !newClassifiers.isEmpty();
			case UML2Package.RECLASSIFY_OBJECT_ACTION__OBJECT:
				return object != null;
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
		result.append(" (isReplaceAll: "); //$NON-NLS-1$
		result.append((eFlags & IS_REPLACE_ALL_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}


} //ReclassifyObjectActionImpl
