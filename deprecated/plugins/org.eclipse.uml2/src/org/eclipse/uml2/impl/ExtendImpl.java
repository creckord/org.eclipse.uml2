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
 * $Id: ExtendImpl.java,v 1.6 2004/06/02 05:02:26 khussey Exp $
 */
package org.eclipse.uml2.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.Constraint;
import org.eclipse.uml2.DirectedRelationship;
import org.eclipse.uml2.Extend;
import org.eclipse.uml2.ExtensionPoint;
import org.eclipse.uml2.Relationship;
import org.eclipse.uml2.StringExpression;
import org.eclipse.uml2.TemplateSignature;
import org.eclipse.uml2.UML2Package;
import org.eclipse.uml2.UseCase;

import org.eclipse.uml2.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extend</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.impl.ExtendImpl#getRelatedElements <em>Related Element</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.ExtendImpl#getSources <em>Source</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.ExtendImpl#getTargets <em>Target</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.ExtendImpl#getExtendedCase <em>Extended Case</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.ExtendImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.ExtendImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.ExtendImpl#getExtensionLocations <em>Extension Location</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtendImpl extends NamedElementImpl implements Extend {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2003, 2004 IBM Corporation and others."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getExtendedCase() <em>Extended Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedCase()
	 * @generated
	 * @ordered
	 */
	protected UseCase extendedCase = null;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected Constraint condition = null;

	/**
	 * The cached value of the '{@link #getExtensionLocations() <em>Extension Location</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionLocations()
	 * @generated
	 * @ordered
	 */
	protected EList extensionLocation = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UML2Package.eINSTANCE.getExtend();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getRelatedElementsGen() {
		EList relatedElement = (EList) getCacheAdapter().get(this, UML2Package.eINSTANCE.getRelationship_RelatedElement());

		if (null == relatedElement) {
			Set union = new LinkedHashSet();

			relatedElement = new EcoreEList.UnmodifiableEList(this, UML2Package.eINSTANCE.getRelationship_RelatedElement(), union.size(), union.toArray());
			getCacheAdapter().put(this, UML2Package.eINSTANCE.getRelationship_RelatedElement(), relatedElement);
		}

		return relatedElement;
	}

	public EList getRelatedElements() {
		EList relatedElements = (EList) getCacheAdapter().get(eResource(),
			this, UML2Package.eINSTANCE.getRelationship_RelatedElement());

		if (null == relatedElements) {
			Set union = new LinkedHashSet();
			union.addAll(getSources());
			union.addAll(getTargets());

			relatedElements = new EcoreEList.UnmodifiableEList(this,
				UML2Package.eINSTANCE.getRelationship_RelatedElement(), union
					.size(), union.toArray());
			getCacheAdapter().put(eResource(), this,
				UML2Package.eINSTANCE.getRelationship_RelatedElement(),
				relatedElements);
		}

		return relatedElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase getExtendedCase() {
		if (extendedCase != null && extendedCase.eIsProxy()) {
			UseCase oldExtendedCase = extendedCase;
			extendedCase = (UseCase)eResolveProxy((InternalEObject)extendedCase);
			if (extendedCase != oldExtendedCase) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UML2Package.EXTEND__EXTENDED_CASE, oldExtendedCase, extendedCase));
			}
		}
		return extendedCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase basicGetExtendedCase() {
		return extendedCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendedCase(UseCase newExtendedCase) {
		UseCase oldExtendedCase = extendedCase;
		extendedCase = newExtendedCase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2Package.EXTEND__EXTENDED_CASE, oldExtendedCase, extendedCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase getExtension() {
		if (eContainerFeatureID != UML2Package.EXTEND__EXTENSION) return null;
		return (UseCase)eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtension(UseCase newExtension) {
		if (newExtension != eContainer || (eContainerFeatureID != UML2Package.EXTEND__EXTENSION && newExtension != null)) {
			if (EcoreUtil.isAncestor(this, newExtension))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eContainer != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newExtension != null)
				msgs = ((InternalEObject)newExtension).eInverseAdd(this, UML2Package.USE_CASE__EXTEND, UseCase.class, msgs);
			msgs = eBasicSetContainer((InternalEObject)newExtension, UML2Package.EXTEND__EXTENSION, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2Package.EXTEND__EXTENSION, newExtension, newExtension));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(Constraint newCondition, NotificationChain msgs) {
		Constraint oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UML2Package.EXTEND__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(Constraint newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UML2Package.EXTEND__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UML2Package.EXTEND__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2Package.EXTEND__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint createCondition(EClass eClass) {
		Constraint newCondition = (Constraint) eClass.getEPackage().getEFactoryInstance().create(eClass);
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, 0, UML2Package.EXTEND__CONDITION, null, newCondition));
		}
        setCondition(newCondition);
		return newCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getExtensionLocations() {
		if (extensionLocation == null) {
			extensionLocation = new EObjectResolvingEList(ExtensionPoint.class, this, UML2Package.EXTEND__EXTENSION_LOCATION);
		}
		return extensionLocation;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
     */
    public ExtensionPoint getExtensionLocation(String unqualifiedName) {
    	for (Iterator i = getExtensionLocations().iterator(); i.hasNext(); ) {
    		ExtensionPoint namedExtensionLocation = (ExtensionPoint) i.next();
    		
    		if (unqualifiedName.equals(namedExtensionLocation.getName())) {
    			return namedExtensionLocation;
    		}
    	}
    	
    	return null;
    }
      
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTargets() {
		EList target = (EList) getCacheAdapter().get(this, UML2Package.eINSTANCE.getDirectedRelationship_Target());

		if (null == target) {
			Set union = new LinkedHashSet();
			if (null != getExtendedCase()) {
				union.add(getExtendedCase());
			}

			target = new EcoreEList.UnmodifiableEList(this, UML2Package.eINSTANCE.getDirectedRelationship_Target(), union.size(), union.toArray());
			getCacheAdapter().put(this, UML2Package.eINSTANCE.getDirectedRelationship_Target(), target);
		}

		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSources() {
		EList source = (EList) getCacheAdapter().get(this, UML2Package.eINSTANCE.getDirectedRelationship_Source());

		if (null == source) {
			Set union = new LinkedHashSet();
			if (null != getExtension()) {
				union.add(getExtension());
			}

			source = new EcoreEList.UnmodifiableEList(this, UML2Package.eINSTANCE.getDirectedRelationship_Source(), union.size(), union.toArray());
			getCacheAdapter().put(this, UML2Package.eINSTANCE.getDirectedRelationship_Source(), source);
		}

		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getOwnedElements() {
		EList ownedElement = (EList) getCacheAdapter().get(this, UML2Package.eINSTANCE.getElement_OwnedElement());

		if (null == ownedElement) {
			Set union = new LinkedHashSet();
			union.addAll(super.getOwnedElements());
			if (null != getCondition()) {
				union.add(getCondition());
			}

			ownedElement = new EcoreEList.UnmodifiableEList(this, UML2Package.eINSTANCE.getElement_OwnedElement(), union.size(), union.toArray());
			getCacheAdapter().put(this, UML2Package.eINSTANCE.getElement_OwnedElement(), ownedElement);
		}

		return ownedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case UML2Package.EXTEND__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case UML2Package.EXTEND__TEMPLATE_BINDING:
					return ((InternalEList)getTemplateBindings()).basicAdd(otherEnd, msgs);
				case UML2Package.EXTEND__OWNED_TEMPLATE_SIGNATURE:
					if (ownedTemplateSignature != null)
						msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UML2Package.EXTEND__OWNED_TEMPLATE_SIGNATURE, null, msgs);
					return basicSetOwnedTemplateSignature((TemplateSignature)otherEnd, msgs);
				case UML2Package.EXTEND__CLIENT_DEPENDENCY:
					return ((InternalEList)getClientDependencies()).basicAdd(otherEnd, msgs);
				case UML2Package.EXTEND__EXTENSION:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, UML2Package.EXTEND__EXTENSION, msgs);
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
				case UML2Package.EXTEND__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case UML2Package.EXTEND__OWNED_COMMENT:
					return ((InternalEList)getOwnedComments()).basicRemove(otherEnd, msgs);
				case UML2Package.EXTEND__TEMPLATE_BINDING:
					return ((InternalEList)getTemplateBindings()).basicRemove(otherEnd, msgs);
				case UML2Package.EXTEND__OWNED_TEMPLATE_SIGNATURE:
					return basicSetOwnedTemplateSignature(null, msgs);
				case UML2Package.EXTEND__CLIENT_DEPENDENCY:
					return ((InternalEList)getClientDependencies()).basicRemove(otherEnd, msgs);
				case UML2Package.EXTEND__NAME_EXPRESSION:
					return basicSetNameExpression(null, msgs);
				case UML2Package.EXTEND__EXTENSION:
					return eBasicSetContainer(null, UML2Package.EXTEND__EXTENSION, msgs);
				case UML2Package.EXTEND__CONDITION:
					return basicSetCondition(null, msgs);
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
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case UML2Package.EXTEND__EXTENSION:
					return eContainer.eInverseRemove(this, UML2Package.USE_CASE__EXTEND, UseCase.class, msgs);
				default:
					return eDynamicBasicRemoveFromContainer(msgs);
			}
		}
		return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case UML2Package.EXTEND__EANNOTATIONS:
				return getEAnnotations();
			case UML2Package.EXTEND__OWNED_ELEMENT:
				return getOwnedElements();
			case UML2Package.EXTEND__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case UML2Package.EXTEND__OWNED_COMMENT:
				return getOwnedComments();
			case UML2Package.EXTEND__TEMPLATE_BINDING:
				return getTemplateBindings();
			case UML2Package.EXTEND__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case UML2Package.EXTEND__NAME:
				return getName();
			case UML2Package.EXTEND__QUALIFIED_NAME:
				return getQualifiedName();
			case UML2Package.EXTEND__VISIBILITY:
				return getVisibility();
			case UML2Package.EXTEND__CLIENT_DEPENDENCY:
				return getClientDependencies();
			case UML2Package.EXTEND__NAME_EXPRESSION:
				return getNameExpression();
			case UML2Package.EXTEND__RELATED_ELEMENT:
				return getRelatedElements();
			case UML2Package.EXTEND__SOURCE:
				return getSources();
			case UML2Package.EXTEND__TARGET:
				return getTargets();
			case UML2Package.EXTEND__EXTENDED_CASE:
				if (resolve) return getExtendedCase();
				return basicGetExtendedCase();
			case UML2Package.EXTEND__EXTENSION:
				return getExtension();
			case UML2Package.EXTEND__CONDITION:
				return getCondition();
			case UML2Package.EXTEND__EXTENSION_LOCATION:
				return getExtensionLocations();
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
			case UML2Package.EXTEND__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case UML2Package.EXTEND__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection)newValue);
				return;
			case UML2Package.EXTEND__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection)newValue);
				return;
			case UML2Package.EXTEND__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case UML2Package.EXTEND__NAME:
				setName((String)newValue);
				return;
			case UML2Package.EXTEND__VISIBILITY:
				setVisibility((VisibilityKind)newValue);
				return;
			case UML2Package.EXTEND__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection)newValue);
				return;
			case UML2Package.EXTEND__NAME_EXPRESSION:
				setNameExpression((StringExpression)newValue);
				return;
			case UML2Package.EXTEND__EXTENDED_CASE:
				setExtendedCase((UseCase)newValue);
				return;
			case UML2Package.EXTEND__EXTENSION:
				setExtension((UseCase)newValue);
				return;
			case UML2Package.EXTEND__CONDITION:
				setCondition((Constraint)newValue);
				return;
			case UML2Package.EXTEND__EXTENSION_LOCATION:
				getExtensionLocations().clear();
				getExtensionLocations().addAll((Collection)newValue);
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
			case UML2Package.EXTEND__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case UML2Package.EXTEND__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case UML2Package.EXTEND__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				return;
			case UML2Package.EXTEND__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case UML2Package.EXTEND__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UML2Package.EXTEND__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case UML2Package.EXTEND__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				return;
			case UML2Package.EXTEND__NAME_EXPRESSION:
				setNameExpression((StringExpression)null);
				return;
			case UML2Package.EXTEND__EXTENDED_CASE:
				setExtendedCase((UseCase)null);
				return;
			case UML2Package.EXTEND__EXTENSION:
				setExtension((UseCase)null);
				return;
			case UML2Package.EXTEND__CONDITION:
				setCondition((Constraint)null);
				return;
			case UML2Package.EXTEND__EXTENSION_LOCATION:
				getExtensionLocations().clear();
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
			case UML2Package.EXTEND__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UML2Package.EXTEND__OWNED_ELEMENT:
				return !getOwnedElements().isEmpty();
			case UML2Package.EXTEND__OWNER:
				return basicGetOwner() != null;
			case UML2Package.EXTEND__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case UML2Package.EXTEND__TEMPLATE_BINDING:
				return templateBinding != null && !templateBinding.isEmpty();
			case UML2Package.EXTEND__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case UML2Package.EXTEND__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UML2Package.EXTEND__QUALIFIED_NAME:
				return !"".equals(getQualifiedName()); //$NON-NLS-1$
			case UML2Package.EXTEND__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case UML2Package.EXTEND__CLIENT_DEPENDENCY:
				return clientDependency != null && !clientDependency.isEmpty();
			case UML2Package.EXTEND__NAME_EXPRESSION:
				return nameExpression != null;
			case UML2Package.EXTEND__RELATED_ELEMENT:
				return !getRelatedElements().isEmpty();
			case UML2Package.EXTEND__SOURCE:
				return !getSources().isEmpty();
			case UML2Package.EXTEND__TARGET:
				return !getTargets().isEmpty();
			case UML2Package.EXTEND__EXTENDED_CASE:
				return extendedCase != null;
			case UML2Package.EXTEND__EXTENSION:
				return getExtension() != null;
			case UML2Package.EXTEND__CONDITION:
				return condition != null;
			case UML2Package.EXTEND__EXTENSION_LOCATION:
				return extensionLocation != null && !extensionLocation.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == Relationship.class) {
			switch (derivedFeatureID) {
				case UML2Package.EXTEND__RELATED_ELEMENT: return UML2Package.RELATIONSHIP__RELATED_ELEMENT;
				default: return -1;
			}
		}
		if (baseClass == DirectedRelationship.class) {
			switch (derivedFeatureID) {
				case UML2Package.EXTEND__SOURCE: return UML2Package.DIRECTED_RELATIONSHIP__SOURCE;
				case UML2Package.EXTEND__TARGET: return UML2Package.DIRECTED_RELATIONSHIP__TARGET;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
		if (baseClass == Relationship.class) {
			switch (baseFeatureID) {
				case UML2Package.RELATIONSHIP__RELATED_ELEMENT: return UML2Package.EXTEND__RELATED_ELEMENT;
				default: return -1;
			}
		}
		if (baseClass == DirectedRelationship.class) {
			switch (baseFeatureID) {
				case UML2Package.DIRECTED_RELATIONSHIP__SOURCE: return UML2Package.EXTEND__SOURCE;
				case UML2Package.DIRECTED_RELATIONSHIP__TARGET: return UML2Package.EXTEND__TARGET;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //ExtendImpl
