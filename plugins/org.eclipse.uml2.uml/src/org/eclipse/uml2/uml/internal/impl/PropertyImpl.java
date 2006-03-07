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
 * $Id: PropertyImpl.java,v 1.28 2006/03/07 20:25:15 khussey Exp $
 */
package org.eclipse.uml2.uml.internal.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.eclipse.uml2.common.util.SubsetSupersetEObjectContainmentWithInverseEList;
import org.eclipse.uml2.common.util.SubsetSupersetEObjectWithInverseResolvingEList;

import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.ConnectableElementTemplateParameter;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.DeploymentTarget;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.RedefinableElement;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.TemplateableElement;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

import org.eclipse.uml2.uml.internal.operations.DeploymentTargetOperations;
import org.eclipse.uml2.uml.internal.operations.ParameterableElementOperations;
import org.eclipse.uml2.uml.internal.operations.PropertyOperations;
import org.eclipse.uml2.uml.internal.operations.TemplateableElementOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getTemplateParameter <em>Template Parameter</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getOwningTemplateParameter <em>Owning Template Parameter</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getEnds <em>End</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getOwnedElements <em>Owned Element</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getClientDependencies <em>Client Dependency</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getDeployments <em>Deployment</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getDeployedElements <em>Deployed Element</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getTemplateBindings <em>Template Binding</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getOwnedTemplateSignature <em>Owned Template Signature</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getFeaturingClassifiers <em>Featuring Classifier</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getRedefinedElements <em>Redefined Element</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getAssociation <em>Association</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getClass_ <em>Class </em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getDatatype <em>Datatype</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#isDerived <em>Is Derived</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#isDerivedUnion <em>Is Derived Union</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getAggregation <em>Aggregation</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#isComposite <em>Is Composite</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getRedefinedProperties <em>Redefined Property</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getOwningAssociation <em>Owning Association</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getSubsettedProperties <em>Subsetted Property</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getQualifiers <em>Qualifier</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#getAssociationEnd <em>Association End</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.PropertyImpl#isReadOnly <em>Is Read Only</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyImpl
		extends StructuralFeatureImpl
		implements Property {

	/**
	 * A bit field representing the indices of non-primitive feature values.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected int eVirtualIndexBits1 = 0;

	/**
	 * The default value of the '{@link #isDerived() <em>Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerived()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DERIVED_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isDerived() <em>Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerived()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_DERIVED_EFLAG = 1 << 13;

	/**
	 * The default value of the '{@link #isDerivedUnion() <em>Is Derived Union</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerivedUnion()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DERIVED_UNION_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isDerivedUnion() <em>Is Derived Union</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerivedUnion()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_DERIVED_UNION_EFLAG = 1 << 14;

	/**
	 * The default value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getAggregation() <em>Aggregation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregation()
	 * @generated
	 * @ordered
	 */
	protected static final AggregationKind AGGREGATION_EDEFAULT = AggregationKind.NONE_LITERAL;

	/**
	 * The default value of the '{@link #isComposite() <em>Is Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComposite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_COMPOSITE_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UMLPackage.Literals.PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameter getTemplateParameter() {
		TemplateParameter templateParameter = (TemplateParameter) eVirtualGet(UMLPackage.PROPERTY__TEMPLATE_PARAMETER);
		if (templateParameter != null && templateParameter.eIsProxy()) {
			InternalEObject oldTemplateParameter = (InternalEObject) templateParameter;
			templateParameter = (TemplateParameter) eResolveProxy(oldTemplateParameter);
			if (templateParameter != oldTemplateParameter) {
				eVirtualSet(UMLPackage.PROPERTY__TEMPLATE_PARAMETER,
					templateParameter);
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						UMLPackage.PROPERTY__TEMPLATE_PARAMETER,
						oldTemplateParameter, templateParameter));
			}
		}
		return templateParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameter basicGetTemplateParameter() {
		return (TemplateParameter) eVirtualGet(UMLPackage.PROPERTY__TEMPLATE_PARAMETER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTemplateParameterGen(
			TemplateParameter newTemplateParameter, NotificationChain msgs) {
		Object oldTemplateParameter = eVirtualSet(
			UMLPackage.PROPERTY__TEMPLATE_PARAMETER, newTemplateParameter);
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET, UMLPackage.PROPERTY__TEMPLATE_PARAMETER,
				oldTemplateParameter == EVIRTUAL_NO_VALUE
					? null
					: oldTemplateParameter, newTemplateParameter);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}

		return msgs;
	}

	public NotificationChain basicSetTemplateParameter(
			TemplateParameter newTemplateParameter, NotificationChain msgs) {

		if (newTemplateParameter != null
			&& !(newTemplateParameter instanceof ConnectableElementTemplateParameter)) {

			throw new IllegalArgumentException(newTemplateParameter.toString());
		}

		msgs = basicSetTemplateParameterGen(newTemplateParameter, msgs);

		Resource.Internal eInternalResource = eInternalResource();

		if (eInternalResource == null || !eInternalResource.isLoading()) {
			TemplateParameter owningTemplateParameter = basicGetOwningTemplateParameter();

			if (owningTemplateParameter != null
				&& owningTemplateParameter != newTemplateParameter) {

				setOwningTemplateParameter(null);
			}
		}

		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplateParameter(TemplateParameter newTemplateParameter) {
		TemplateParameter templateParameter = (TemplateParameter) eVirtualGet(UMLPackage.PROPERTY__TEMPLATE_PARAMETER);
		if (newTemplateParameter != templateParameter) {
			NotificationChain msgs = null;
			if (templateParameter != null)
				msgs = ((InternalEObject) templateParameter).eInverseRemove(
					this, UMLPackage.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT,
					TemplateParameter.class, msgs);
			if (newTemplateParameter != null)
				msgs = ((InternalEObject) newTemplateParameter).eInverseAdd(
					this, UMLPackage.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT,
					TemplateParameter.class, msgs);
			msgs = basicSetTemplateParameter(newTemplateParameter, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.PROPERTY__TEMPLATE_PARAMETER, newTemplateParameter,
				newTemplateParameter));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTemplateParameter() {
		return eVirtualGet(UMLPackage.PROPERTY__TEMPLATE_PARAMETER) != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameter getOwningTemplateParameter() {
		if (eContainerFeatureID != UMLPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER)
			return null;
		return (TemplateParameter) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameter basicGetOwningTemplateParameter() {
		if (eContainerFeatureID != UMLPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER)
			return null;
		return (TemplateParameter) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTemplateParameter(
			TemplateParameter newOwningTemplateParameter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newOwningTemplateParameter,
			UMLPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER, msgs);

		Resource.Internal eInternalResource = eInternalResource();
		if (eInternalResource == null || !eInternalResource.isLoading()) {
			if (newOwningTemplateParameter != null) {
				Object templateParameter = eVirtualGet(UMLPackage.PROPERTY__TEMPLATE_PARAMETER);
				if (newOwningTemplateParameter != templateParameter) {
					setTemplateParameter(newOwningTemplateParameter);
				}
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningTemplateParameter(
			TemplateParameter newOwningTemplateParameter) {
		if (newOwningTemplateParameter != eInternalContainer()
			|| (eContainerFeatureID != UMLPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER && newOwningTemplateParameter != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTemplateParameter))
				throw new IllegalArgumentException(
					"Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTemplateParameter != null)
				msgs = ((InternalEObject) newOwningTemplateParameter)
					.eInverseAdd(
						this,
						UMLPackage.TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT,
						TemplateParameter.class, msgs);
			msgs = basicSetOwningTemplateParameter(newOwningTemplateParameter,
				msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER,
				newOwningTemplateParameter, newOwningTemplateParameter));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getEnds() {
		EList end = (EList) eVirtualGet(UMLPackage.PROPERTY__END);
		if (end == null) {
			eVirtualSet(UMLPackage.PROPERTY__END,
				end = new EObjectWithInverseResolvingEList(ConnectorEnd.class,
					this, UMLPackage.PROPERTY__END,
					UMLPackage.CONNECTOR_END__ROLE));
		}
		return end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getOwnedElements() {
		EList ownedElement = (EList) eVirtualGet(UMLPackage.PROPERTY__OWNED_ELEMENT);
		if (ownedElement == null) {
			eVirtualSet(UMLPackage.PROPERTY__OWNED_ELEMENT,
				ownedElement = new DerivedUnionEObjectEList(Element.class,
					this, UMLPackage.PROPERTY__OWNED_ELEMENT, new int[]{
						UMLPackage.PROPERTY__OWNED_COMMENT,
						UMLPackage.PROPERTY__NAME_EXPRESSION,
						UMLPackage.PROPERTY__UPPER_VALUE,
						UMLPackage.PROPERTY__LOWER_VALUE,
						UMLPackage.PROPERTY__DEPLOYMENT,
						UMLPackage.PROPERTY__TEMPLATE_BINDING,
						UMLPackage.PROPERTY__OWNED_TEMPLATE_SIGNATURE,
						UMLPackage.PROPERTY__DEFAULT_VALUE,
						UMLPackage.PROPERTY__QUALIFIER}));
		}
		return ownedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getClientDependencies() {
		EList clientDependency = (EList) eVirtualGet(UMLPackage.PROPERTY__CLIENT_DEPENDENCY);
		if (clientDependency == null) {
			eVirtualSet(
				UMLPackage.PROPERTY__CLIENT_DEPENDENCY,
				clientDependency = new SubsetSupersetEObjectWithInverseResolvingEList.ManyInverse(
					Dependency.class, this,
					UMLPackage.PROPERTY__CLIENT_DEPENDENCY, null,
					new int[]{UMLPackage.PROPERTY__DEPLOYMENT},
					UMLPackage.DEPENDENCY__CLIENT));
		}
		return clientDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDeployments() {
		EList deployment = (EList) eVirtualGet(UMLPackage.PROPERTY__DEPLOYMENT);
		if (deployment == null) {
			eVirtualSet(
				UMLPackage.PROPERTY__DEPLOYMENT,
				deployment = new SubsetSupersetEObjectContainmentWithInverseEList.Resolving(
					Deployment.class, this, UMLPackage.PROPERTY__DEPLOYMENT,
					new int[]{UMLPackage.PROPERTY__CLIENT_DEPENDENCY}, null,
					UMLPackage.DEPLOYMENT__LOCATION));
		}
		return deployment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deployment createDeployment(String name) {
		Deployment newDeployment = (Deployment) create(UMLPackage.Literals.DEPLOYMENT);
		if (name != null)
			newDeployment.setName(name);
		getDeployments().add(newDeployment);
		return newDeployment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deployment getDeployment(String name) {
		return getDeployment(name, false, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deployment getDeployment(String name, boolean ignoreCase,
			boolean createOnDemand) {
		deploymentLoop : for (Iterator i = getDeployments().iterator(); i
			.hasNext();) {
			Deployment deployment = (Deployment) i.next();
			if (name != null && !(ignoreCase
				? name.equalsIgnoreCase(deployment.getName())
				: name.equals(deployment.getName())))
				continue deploymentLoop;
			return deployment;
		}
		return createOnDemand
			? createDeployment(name)
			: null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDeployedElements() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			EList result = (EList) cache.get(this,
				UMLPackage.Literals.DEPLOYMENT_TARGET__DEPLOYED_ELEMENT);
			if (result == null) {
				cache.put(this,
					UMLPackage.Literals.DEPLOYMENT_TARGET__DEPLOYED_ELEMENT,
					result = DeploymentTargetOperations
						.getDeployedElements(this));
			}
			return result;
		}
		return DeploymentTargetOperations.getDeployedElements(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageableElement getDeployedElement(String name) {
		return getDeployedElement(name, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageableElement getDeployedElement(String name,
			boolean ignoreCase, EClass eClass) {
		deployedElementLoop : for (Iterator i = getDeployedElements()
			.iterator(); i.hasNext();) {
			PackageableElement deployedElement = (PackageableElement) i.next();
			if (eClass != null && !eClass.isInstance(deployedElement))
				continue deployedElementLoop;
			if (name != null && !(ignoreCase
				? name.equalsIgnoreCase(deployedElement.getName())
				: name.equals(deployedElement.getName())))
				continue deployedElementLoop;
			return deployedElement;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTemplateBindings() {
		EList templateBinding = (EList) eVirtualGet(UMLPackage.PROPERTY__TEMPLATE_BINDING);
		if (templateBinding == null) {
			eVirtualSet(
				UMLPackage.PROPERTY__TEMPLATE_BINDING,
				templateBinding = new EObjectContainmentWithInverseEList.Resolving(
					TemplateBinding.class, this,
					UMLPackage.PROPERTY__TEMPLATE_BINDING,
					UMLPackage.TEMPLATE_BINDING__BOUND_ELEMENT));
		}
		return templateBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateBinding createTemplateBinding(TemplateSignature signature) {
		TemplateBinding newTemplateBinding = (TemplateBinding) create(UMLPackage.Literals.TEMPLATE_BINDING);
		if (signature != null)
			newTemplateBinding.setSignature(signature);
		getTemplateBindings().add(newTemplateBinding);
		return newTemplateBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateBinding getTemplateBinding(TemplateSignature signature) {
		return getTemplateBinding(signature, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateBinding getTemplateBinding(TemplateSignature signature,
			boolean createOnDemand) {
		templateBindingLoop : for (Iterator i = getTemplateBindings()
			.iterator(); i.hasNext();) {
			TemplateBinding templateBinding = (TemplateBinding) i.next();
			if (signature != null
				&& !signature.equals(templateBinding.getSignature()))
				continue templateBindingLoop;
			return templateBinding;
		}
		return createOnDemand
			? createTemplateBinding(signature)
			: null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateSignature getOwnedTemplateSignature() {
		TemplateSignature ownedTemplateSignature = (TemplateSignature) eVirtualGet(UMLPackage.PROPERTY__OWNED_TEMPLATE_SIGNATURE);
		if (ownedTemplateSignature != null && ownedTemplateSignature.eIsProxy()) {
			InternalEObject oldOwnedTemplateSignature = (InternalEObject) ownedTemplateSignature;
			ownedTemplateSignature = (TemplateSignature) eResolveProxy(oldOwnedTemplateSignature);
			if (ownedTemplateSignature != oldOwnedTemplateSignature) {
				InternalEObject newOwnedTemplateSignature = (InternalEObject) ownedTemplateSignature;
				NotificationChain msgs = oldOwnedTemplateSignature
					.eInverseRemove(this,
						UMLPackage.TEMPLATE_SIGNATURE__TEMPLATE,
						TemplateSignature.class, null);
				if (newOwnedTemplateSignature.eInternalContainer() == null) {
					msgs = newOwnedTemplateSignature.eInverseAdd(this,
						UMLPackage.TEMPLATE_SIGNATURE__TEMPLATE,
						TemplateSignature.class, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						UMLPackage.PROPERTY__OWNED_TEMPLATE_SIGNATURE,
						oldOwnedTemplateSignature, ownedTemplateSignature));
			}
		}
		return ownedTemplateSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateSignature basicGetOwnedTemplateSignature() {
		return (TemplateSignature) eVirtualGet(UMLPackage.PROPERTY__OWNED_TEMPLATE_SIGNATURE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedTemplateSignature(
			TemplateSignature newOwnedTemplateSignature, NotificationChain msgs) {
		Object oldOwnedTemplateSignature = eVirtualSet(
			UMLPackage.PROPERTY__OWNED_TEMPLATE_SIGNATURE,
			newOwnedTemplateSignature);
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET,
				UMLPackage.PROPERTY__OWNED_TEMPLATE_SIGNATURE,
				oldOwnedTemplateSignature == EVIRTUAL_NO_VALUE
					? null
					: oldOwnedTemplateSignature, newOwnedTemplateSignature);
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
	public void setOwnedTemplateSignature(
			TemplateSignature newOwnedTemplateSignature) {
		TemplateSignature ownedTemplateSignature = (TemplateSignature) eVirtualGet(UMLPackage.PROPERTY__OWNED_TEMPLATE_SIGNATURE);
		if (newOwnedTemplateSignature != ownedTemplateSignature) {
			NotificationChain msgs = null;
			if (ownedTemplateSignature != null)
				msgs = ((InternalEObject) ownedTemplateSignature)
					.eInverseRemove(this,
						UMLPackage.TEMPLATE_SIGNATURE__TEMPLATE,
						TemplateSignature.class, msgs);
			if (newOwnedTemplateSignature != null)
				msgs = ((InternalEObject) newOwnedTemplateSignature)
					.eInverseAdd(this, UMLPackage.TEMPLATE_SIGNATURE__TEMPLATE,
						TemplateSignature.class, msgs);
			msgs = basicSetOwnedTemplateSignature(newOwnedTemplateSignature,
				msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.PROPERTY__OWNED_TEMPLATE_SIGNATURE,
				newOwnedTemplateSignature, newOwnedTemplateSignature));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateSignature createOwnedTemplateSignature(EClass eClass) {
		TemplateSignature newOwnedTemplateSignature = (TemplateSignature) create(eClass);
		setOwnedTemplateSignature(newOwnedTemplateSignature);
		return newOwnedTemplateSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateSignature createOwnedTemplateSignature() {
		return createOwnedTemplateSignature(UMLPackage.Literals.TEMPLATE_SIGNATURE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getFeaturingClassifiers() {
		EList featuringClassifier = (EList) eVirtualGet(UMLPackage.PROPERTY__FEATURING_CLASSIFIER);
		if (featuringClassifier == null) {
			eVirtualSet(UMLPackage.PROPERTY__FEATURING_CLASSIFIER,
				featuringClassifier = new DerivedUnionEObjectEList(
					Classifier.class, this,
					UMLPackage.PROPERTY__FEATURING_CLASSIFIER, new int[]{
						UMLPackage.PROPERTY__CLASS_,
						UMLPackage.PROPERTY__DATATYPE,
						UMLPackage.PROPERTY__OWNING_ASSOCIATION}));
		}
		return featuringClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getRedefinedElements() {
		EList redefinedElement = (EList) eVirtualGet(UMLPackage.PROPERTY__REDEFINED_ELEMENT);
		if (redefinedElement == null) {
			eVirtualSet(UMLPackage.PROPERTY__REDEFINED_ELEMENT,
				redefinedElement = new DerivedUnionEObjectEList(
					RedefinableElement.class, this,
					UMLPackage.PROPERTY__REDEFINED_ELEMENT,
					new int[]{UMLPackage.PROPERTY__REDEFINED_PROPERTY}));
		}
		return redefinedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Association getAssociation() {
		Association association = (Association) eVirtualGet(UMLPackage.PROPERTY__ASSOCIATION);
		if (association != null && association.eIsProxy()) {
			InternalEObject oldAssociation = (InternalEObject) association;
			association = (Association) eResolveProxy(oldAssociation);
			if (association != oldAssociation) {
				eVirtualSet(UMLPackage.PROPERTY__ASSOCIATION, association);
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						UMLPackage.PROPERTY__ASSOCIATION, oldAssociation,
						association));
			}
		}
		return association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Association basicGetAssociation() {
		return (Association) eVirtualGet(UMLPackage.PROPERTY__ASSOCIATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssociation(Association newAssociation,
			NotificationChain msgs) {
		Object oldAssociation = eVirtualSet(UMLPackage.PROPERTY__ASSOCIATION,
			newAssociation);
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET, UMLPackage.PROPERTY__ASSOCIATION,
				oldAssociation == EVIRTUAL_NO_VALUE
					? null
					: oldAssociation, newAssociation);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}

		Resource.Internal eInternalResource = eInternalResource();
		if (eInternalResource == null || !eInternalResource.isLoading()) {
			Association owningAssociation = basicGetOwningAssociation();
			if (owningAssociation != null
				&& owningAssociation != newAssociation) {
				setOwningAssociation(null);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociation(Association newAssociation) {
		Association association = (Association) eVirtualGet(UMLPackage.PROPERTY__ASSOCIATION);
		if (newAssociation != association) {
			NotificationChain msgs = null;
			if (association != null)
				msgs = ((InternalEObject) association)
					.eInverseRemove(this, UMLPackage.ASSOCIATION__MEMBER_END,
						Association.class, msgs);
			if (newAssociation != null)
				msgs = ((InternalEObject) newAssociation)
					.eInverseAdd(this, UMLPackage.ASSOCIATION__MEMBER_END,
						Association.class, msgs);
			msgs = basicSetAssociation(newAssociation, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.PROPERTY__ASSOCIATION, newAssociation,
				newAssociation));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getDatatype() {
		if (eContainerFeatureID != UMLPackage.PROPERTY__DATATYPE)
			return null;
		return (DataType) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDatatype(DataType newDatatype,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newDatatype,
			UMLPackage.PROPERTY__DATATYPE, msgs);

		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatatype(DataType newDatatype) {
		if (newDatatype != eInternalContainer()
			|| (eContainerFeatureID != UMLPackage.PROPERTY__DATATYPE && newDatatype != null)) {
			if (EcoreUtil.isAncestor(this, newDatatype))
				throw new IllegalArgumentException(
					"Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDatatype != null)
				msgs = ((InternalEObject) newDatatype)
					.eInverseAdd(this, UMLPackage.DATA_TYPE__OWNED_ATTRIBUTE,
						DataType.class, msgs);
			msgs = basicSetDatatype(newDatatype, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.PROPERTY__DATATYPE, newDatatype, newDatatype));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDerived() {
		return (eFlags & IS_DERIVED_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDerived(boolean newIsDerived) {
		boolean oldIsDerived = (eFlags & IS_DERIVED_EFLAG) != 0;
		if (newIsDerived)
			eFlags |= IS_DERIVED_EFLAG;
		else
			eFlags &= ~IS_DERIVED_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.PROPERTY__IS_DERIVED, oldIsDerived, newIsDerived));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDerivedUnion() {
		return (eFlags & IS_DERIVED_UNION_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDerivedUnion(boolean newIsDerivedUnion) {
		boolean oldIsDerivedUnion = (eFlags & IS_DERIVED_UNION_EFLAG) != 0;
		if (newIsDerivedUnion)
			eFlags |= IS_DERIVED_UNION_EFLAG;
		else
			eFlags &= ~IS_DERIVED_UNION_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.PROPERTY__IS_DERIVED_UNION, oldIsDerivedUnion,
				newIsDerivedUnion));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefault() {
		return PropertyOperations.getDefault(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(String newDefault) {
		PropertyOperations.setDefault(this, newDefault);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDefault() {
		PropertyOperations.unsetDefault(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDefault() {
		return PropertyOperations.isSetDefault(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregationKind getAggregation() {
		return (AggregationKind) eVirtualGet(UMLPackage.PROPERTY__AGGREGATION,
			AGGREGATION_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregation(AggregationKind newAggregation) {
		AggregationKind aggregation = newAggregation == null
			? AGGREGATION_EDEFAULT
			: newAggregation;
		Object oldAggregation = eVirtualSet(UMLPackage.PROPERTY__AGGREGATION,
			aggregation);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.PROPERTY__AGGREGATION,
				oldAggregation == EVIRTUAL_NO_VALUE
					? AGGREGATION_EDEFAULT
					: oldAggregation, aggregation));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComposite() {
		return PropertyOperations.isComposite(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsComposite(boolean newIsComposite) {
		PropertyOperations.setIsComposite(this, newIsComposite);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public org.eclipse.uml2.uml.Class getClass_() {
		return eInternalContainer() instanceof org.eclipse.uml2.uml.Class
			? (org.eclipse.uml2.uml.Class) eContainer()
			: null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getRedefinedProperties() {
		EList redefinedProperty = (EList) eVirtualGet(UMLPackage.PROPERTY__REDEFINED_PROPERTY);
		if (redefinedProperty == null) {
			eVirtualSet(UMLPackage.PROPERTY__REDEFINED_PROPERTY,
				redefinedProperty = new EObjectResolvingEList(Property.class,
					this, UMLPackage.PROPERTY__REDEFINED_PROPERTY));
		}
		return redefinedProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getRedefinedProperty(String name, Type type) {
		return getRedefinedProperty(name, type, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getRedefinedProperty(String name, Type type,
			boolean ignoreCase, EClass eClass) {
		redefinedPropertyLoop : for (Iterator i = getRedefinedProperties()
			.iterator(); i.hasNext();) {
			Property redefinedProperty = (Property) i.next();
			if (eClass != null && !eClass.isInstance(redefinedProperty))
				continue redefinedPropertyLoop;
			if (name != null && !(ignoreCase
				? name.equalsIgnoreCase(redefinedProperty.getName())
				: name.equals(redefinedProperty.getName())))
				continue redefinedPropertyLoop;
			if (type != null && !type.equals(redefinedProperty.getType()))
				continue redefinedPropertyLoop;
			return redefinedProperty;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Association getOwningAssociation() {
		if (eContainerFeatureID != UMLPackage.PROPERTY__OWNING_ASSOCIATION)
			return null;
		return (Association) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Association basicGetOwningAssociation() {
		if (eContainerFeatureID != UMLPackage.PROPERTY__OWNING_ASSOCIATION)
			return null;
		return (Association) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningAssociation(
			Association newOwningAssociation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newOwningAssociation,
			UMLPackage.PROPERTY__OWNING_ASSOCIATION, msgs);

		Resource.Internal eInternalResource = eInternalResource();
		if (eInternalResource == null || !eInternalResource.isLoading()) {
			if (newOwningAssociation != null) {
				Object association = eVirtualGet(UMLPackage.PROPERTY__ASSOCIATION);
				if (newOwningAssociation != association) {
					setAssociation(newOwningAssociation);
				}
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningAssociation(Association newOwningAssociation) {
		if (newOwningAssociation != eInternalContainer()
			|| (eContainerFeatureID != UMLPackage.PROPERTY__OWNING_ASSOCIATION && newOwningAssociation != null)) {
			if (EcoreUtil.isAncestor(this, newOwningAssociation))
				throw new IllegalArgumentException(
					"Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningAssociation != null)
				msgs = ((InternalEObject) newOwningAssociation).eInverseAdd(
					this, UMLPackage.ASSOCIATION__OWNED_END, Association.class,
					msgs);
			msgs = basicSetOwningAssociation(newOwningAssociation, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.PROPERTY__OWNING_ASSOCIATION, newOwningAssociation,
				newOwningAssociation));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSpecification getDefaultValue() {
		ValueSpecification defaultValue = (ValueSpecification) eVirtualGet(UMLPackage.PROPERTY__DEFAULT_VALUE);
		if (defaultValue != null && defaultValue.eIsProxy()) {
			InternalEObject oldDefaultValue = (InternalEObject) defaultValue;
			defaultValue = (ValueSpecification) eResolveProxy(oldDefaultValue);
			if (defaultValue != oldDefaultValue) {
				InternalEObject newDefaultValue = (InternalEObject) defaultValue;
				NotificationChain msgs = oldDefaultValue
					.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- UMLPackage.PROPERTY__DEFAULT_VALUE, null, null);
				if (newDefaultValue.eInternalContainer() == null) {
					msgs = newDefaultValue.eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
							- UMLPackage.PROPERTY__DEFAULT_VALUE, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						UMLPackage.PROPERTY__DEFAULT_VALUE, oldDefaultValue,
						defaultValue));
			}
		}
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSpecification basicGetDefaultValue() {
		return (ValueSpecification) eVirtualGet(UMLPackage.PROPERTY__DEFAULT_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultValue(
			ValueSpecification newDefaultValue, NotificationChain msgs) {
		Object oldDefaultValue = eVirtualSet(
			UMLPackage.PROPERTY__DEFAULT_VALUE, newDefaultValue);
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET, UMLPackage.PROPERTY__DEFAULT_VALUE,
				oldDefaultValue == EVIRTUAL_NO_VALUE
					? null
					: oldDefaultValue, newDefaultValue);
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
	public void setDefaultValue(ValueSpecification newDefaultValue) {
		ValueSpecification defaultValue = (ValueSpecification) eVirtualGet(UMLPackage.PROPERTY__DEFAULT_VALUE);
		if (newDefaultValue != defaultValue) {
			NotificationChain msgs = null;
			if (defaultValue != null)
				msgs = ((InternalEObject) defaultValue)
					.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- UMLPackage.PROPERTY__DEFAULT_VALUE, null, msgs);
			if (newDefaultValue != null)
				msgs = ((InternalEObject) newDefaultValue)
					.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- UMLPackage.PROPERTY__DEFAULT_VALUE, null, msgs);
			msgs = basicSetDefaultValue(newDefaultValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.PROPERTY__DEFAULT_VALUE, newDefaultValue,
				newDefaultValue));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSpecification createDefaultValue(String name, Type type,
			EClass eClass) {
		ValueSpecification newDefaultValue = (ValueSpecification) create(eClass);
		if (name != null)
			newDefaultValue.setName(name);
		if (type != null)
			newDefaultValue.setType(type);
		setDefaultValue(newDefaultValue);
		return newDefaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getOpposite() {
		Property opposite = basicGetOpposite();
		return opposite != null && opposite.eIsProxy()
			? (Property) eResolveProxy((InternalEObject) opposite)
			: opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetOpposite() {
		return PropertyOperations.getOpposite(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpposite(Property newOpposite) {
		PropertyOperations.setOpposite(this, newOpposite);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSubsettedProperties() {
		EList subsettedProperty = (EList) eVirtualGet(UMLPackage.PROPERTY__SUBSETTED_PROPERTY);
		if (subsettedProperty == null) {
			eVirtualSet(UMLPackage.PROPERTY__SUBSETTED_PROPERTY,
				subsettedProperty = new EObjectResolvingEList(Property.class,
					this, UMLPackage.PROPERTY__SUBSETTED_PROPERTY));
		}
		return subsettedProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getSubsettedProperty(String name, Type type) {
		return getSubsettedProperty(name, type, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getSubsettedProperty(String name, Type type,
			boolean ignoreCase, EClass eClass) {
		subsettedPropertyLoop : for (Iterator i = getSubsettedProperties()
			.iterator(); i.hasNext();) {
			Property subsettedProperty = (Property) i.next();
			if (eClass != null && !eClass.isInstance(subsettedProperty))
				continue subsettedPropertyLoop;
			if (name != null && !(ignoreCase
				? name.equalsIgnoreCase(subsettedProperty.getName())
				: name.equals(subsettedProperty.getName())))
				continue subsettedPropertyLoop;
			if (type != null && !type.equals(subsettedProperty.getType()))
				continue subsettedPropertyLoop;
			return subsettedProperty;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getQualifiers() {
		EList qualifier = (EList) eVirtualGet(UMLPackage.PROPERTY__QUALIFIER);
		if (qualifier == null) {
			eVirtualSet(UMLPackage.PROPERTY__QUALIFIER,
				qualifier = new EObjectContainmentWithInverseEList.Resolving(
					Property.class, this, UMLPackage.PROPERTY__QUALIFIER,
					UMLPackage.PROPERTY__ASSOCIATION_END));
		}
		return qualifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createQualifier(String name, Type type, EClass eClass) {
		Property newQualifier = (Property) create(eClass);
		if (name != null)
			newQualifier.setName(name);
		if (type != null)
			newQualifier.setType(type);
		getQualifiers().add(newQualifier);
		return newQualifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createQualifier(String name, Type type) {
		return createQualifier(name, type, UMLPackage.Literals.PROPERTY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getQualifier(String name, Type type) {
		return getQualifier(name, type, false, null, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getQualifier(String name, Type type, boolean ignoreCase,
			EClass eClass, boolean createOnDemand) {
		qualifierLoop : for (Iterator i = getQualifiers().iterator(); i
			.hasNext();) {
			Property qualifier = (Property) i.next();
			if (eClass != null && !eClass.isInstance(qualifier))
				continue qualifierLoop;
			if (name != null && !(ignoreCase
				? name.equalsIgnoreCase(qualifier.getName())
				: name.equals(qualifier.getName())))
				continue qualifierLoop;
			if (type != null && !type.equals(qualifier.getType()))
				continue qualifierLoop;
			return qualifier;
		}
		return createOnDemand && eClass != null
			? createQualifier(name, type, eClass)
			: null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getAssociationEnd() {
		if (eContainerFeatureID != UMLPackage.PROPERTY__ASSOCIATION_END)
			return null;
		return (Property) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssociationEnd(Property newAssociationEnd,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newAssociationEnd,
			UMLPackage.PROPERTY__ASSOCIATION_END, msgs);

		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociationEnd(Property newAssociationEnd) {
		if (newAssociationEnd != eInternalContainer()
			|| (eContainerFeatureID != UMLPackage.PROPERTY__ASSOCIATION_END && newAssociationEnd != null)) {
			if (EcoreUtil.isAncestor(this, newAssociationEnd))
				throw new IllegalArgumentException(
					"Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAssociationEnd != null)
				msgs = ((InternalEObject) newAssociationEnd).eInverseAdd(this,
					UMLPackage.PROPERTY__QUALIFIER, Property.class, msgs);
			msgs = basicSetAssociationEnd(newAssociationEnd, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.PROPERTY__ASSOCIATION_END, newAssociationEnd,
				newAssociationEnd));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReadOnly() {
		return (eFlags & IS_READ_ONLY_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsReadOnly(boolean newIsReadOnly) {
		boolean oldIsReadOnly = (eFlags & IS_READ_ONLY_EFLAG) != 0;
		if (newIsReadOnly)
			eFlags |= IS_READ_ONLY_EFLAG;
		else
			eFlags &= ~IS_READ_ONLY_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.PROPERTY__IS_READ_ONLY, oldIsReadOnly, newIsReadOnly));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsReadOnly() {
		return ((eFlags & IS_READ_ONLY_EFLAG) != 0) != IS_READ_ONLY_EDEFAULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCompatibleWith(ParameterableElement p) {
		return PropertyOperations.isCompatibleWith(this, p);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTemplateParameter() {
		return ParameterableElementOperations.isTemplateParameter(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList parameterableElements() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			EList result = (EList) cache.get(eResource(), this,
				UMLPackage.Literals.TEMPLATEABLE_ELEMENT.getEOperations()
					.get(0));
			if (result == null) {
				cache.put(eResource(), this,
					UMLPackage.Literals.TEMPLATEABLE_ELEMENT.getEOperations()
						.get(0), result = TemplateableElementOperations
						.parameterableElements(this));
			}
			return result;
		}
		return TemplateableElementOperations.parameterableElements(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTemplate() {
		return TemplateableElementOperations.isTemplate(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiplicityOfComposite(DiagnosticChain diagnostics,
			Map context) {
		return PropertyOperations.validateMultiplicityOfComposite(this,
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubsettingContextConforms(
			DiagnosticChain diagnostics, Map context) {
		return PropertyOperations.validateSubsettingContextConforms(this,
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRedefinedPropertyInherited(
			DiagnosticChain diagnostics, Map context) {
		return PropertyOperations.validateRedefinedPropertyInherited(this,
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubsettingRules(DiagnosticChain diagnostics,
			Map context) {
		return PropertyOperations.validateSubsettingRules(this, diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNavigableReadonly(DiagnosticChain diagnostics,
			Map context) {
		return PropertyOperations.validateNavigableReadonly(this, diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDerivedUnionIsDerived(DiagnosticChain diagnostics,
			Map context) {
		return PropertyOperations.validateDerivedUnionIsDerived(this,
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDerivedUnionIsReadOnly(DiagnosticChain diagnostics,
			Map context) {
		return PropertyOperations.validateDerivedUnionIsReadOnly(this,
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubsettedPropertyNames(DiagnosticChain diagnostics,
			Map context) {
		return PropertyOperations.validateSubsettedPropertyNames(this,
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeploymentTarget(DiagnosticChain diagnostics,
			Map context) {
		return PropertyOperations.validateDeploymentTarget(this, diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBindingToAttribute(DiagnosticChain diagnostics,
			Map context) {
		return PropertyOperations.validateBindingToAttribute(this, diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAttribute(Property p) {
		return PropertyOperations.isAttribute(this, p);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList subsettingContext() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			EList result = (EList) cache.get(this, UMLPackage.Literals.PROPERTY
				.getEOperations().get(19));
			if (result == null) {
				cache.put(this, UMLPackage.Literals.PROPERTY.getEOperations()
					.get(19), result = PropertyOperations
					.subsettingContext(this));
			}
			return result;
		}
		return PropertyOperations.subsettingContext(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNavigable() {
		return PropertyOperations.isNavigable(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConsistentWith(RedefinableElement redefinee) {
		return PropertyOperations.isConsistentWith(this, redefinee);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLPackage.PROPERTY__EANNOTATIONS :
				return ((InternalEList) getEAnnotations()).basicAdd(otherEnd,
					msgs);
			case UMLPackage.PROPERTY__CLIENT_DEPENDENCY :
				return ((InternalEList) getClientDependencies()).basicAdd(
					otherEnd, msgs);
			case UMLPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER :
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTemplateParameter(
					(TemplateParameter) otherEnd, msgs);
			case UMLPackage.PROPERTY__TEMPLATE_PARAMETER :
				TemplateParameter templateParameter = (TemplateParameter) eVirtualGet(UMLPackage.PROPERTY__TEMPLATE_PARAMETER);
				if (templateParameter != null)
					msgs = ((InternalEObject) templateParameter)
						.eInverseRemove(this,
							UMLPackage.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT,
							TemplateParameter.class, msgs);
				return basicSetTemplateParameter((TemplateParameter) otherEnd,
					msgs);
			case UMLPackage.PROPERTY__END :
				return ((InternalEList) getEnds()).basicAdd(otherEnd, msgs);
			case UMLPackage.PROPERTY__DEPLOYMENT :
				return ((InternalEList) getDeployments()).basicAdd(otherEnd,
					msgs);
			case UMLPackage.PROPERTY__TEMPLATE_BINDING :
				return ((InternalEList) getTemplateBindings()).basicAdd(
					otherEnd, msgs);
			case UMLPackage.PROPERTY__OWNED_TEMPLATE_SIGNATURE :
				TemplateSignature ownedTemplateSignature = (TemplateSignature) eVirtualGet(UMLPackage.PROPERTY__OWNED_TEMPLATE_SIGNATURE);
				if (ownedTemplateSignature != null)
					msgs = ((InternalEObject) ownedTemplateSignature)
						.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
							- UMLPackage.PROPERTY__OWNED_TEMPLATE_SIGNATURE,
							null, msgs);
				return basicSetOwnedTemplateSignature(
					(TemplateSignature) otherEnd, msgs);
			case UMLPackage.PROPERTY__DATATYPE :
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDatatype((DataType) otherEnd, msgs);
			case UMLPackage.PROPERTY__OWNING_ASSOCIATION :
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningAssociation((Association) otherEnd, msgs);
			case UMLPackage.PROPERTY__ASSOCIATION :
				Association association = (Association) eVirtualGet(UMLPackage.PROPERTY__ASSOCIATION);
				if (association != null)
					msgs = ((InternalEObject) association).eInverseRemove(this,
						UMLPackage.ASSOCIATION__MEMBER_END, Association.class,
						msgs);
				return basicSetAssociation((Association) otherEnd, msgs);
			case UMLPackage.PROPERTY__QUALIFIER :
				return ((InternalEList) getQualifiers()).basicAdd(otherEnd,
					msgs);
			case UMLPackage.PROPERTY__ASSOCIATION_END :
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAssociationEnd((Property) otherEnd, msgs);
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
			case UMLPackage.PROPERTY__EANNOTATIONS :
				return ((InternalEList) getEAnnotations()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.PROPERTY__OWNED_COMMENT :
				return ((InternalEList) getOwnedComments()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.PROPERTY__CLIENT_DEPENDENCY :
				return ((InternalEList) getClientDependencies()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.PROPERTY__NAME_EXPRESSION :
				return basicSetNameExpression(null, msgs);
			case UMLPackage.PROPERTY__UPPER_VALUE :
				return basicSetUpperValue(null, msgs);
			case UMLPackage.PROPERTY__LOWER_VALUE :
				return basicSetLowerValue(null, msgs);
			case UMLPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER :
				return basicSetOwningTemplateParameter(null, msgs);
			case UMLPackage.PROPERTY__TEMPLATE_PARAMETER :
				return basicSetTemplateParameter(null, msgs);
			case UMLPackage.PROPERTY__END :
				return ((InternalEList) getEnds()).basicRemove(otherEnd, msgs);
			case UMLPackage.PROPERTY__DEPLOYMENT :
				return ((InternalEList) getDeployments()).basicRemove(otherEnd,
					msgs);
			case UMLPackage.PROPERTY__TEMPLATE_BINDING :
				return ((InternalEList) getTemplateBindings()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.PROPERTY__OWNED_TEMPLATE_SIGNATURE :
				return basicSetOwnedTemplateSignature(null, msgs);
			case UMLPackage.PROPERTY__DATATYPE :
				return basicSetDatatype(null, msgs);
			case UMLPackage.PROPERTY__OWNING_ASSOCIATION :
				return basicSetOwningAssociation(null, msgs);
			case UMLPackage.PROPERTY__DEFAULT_VALUE :
				return basicSetDefaultValue(null, msgs);
			case UMLPackage.PROPERTY__ASSOCIATION :
				return basicSetAssociation(null, msgs);
			case UMLPackage.PROPERTY__QUALIFIER :
				return ((InternalEList) getQualifiers()).basicRemove(otherEnd,
					msgs);
			case UMLPackage.PROPERTY__ASSOCIATION_END :
				return basicSetAssociationEnd(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case UMLPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER :
				return eInternalContainer().eInverseRemove(this,
					UMLPackage.TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT,
					TemplateParameter.class, msgs);
			case UMLPackage.PROPERTY__DATATYPE :
				return eInternalContainer()
					.eInverseRemove(this,
						UMLPackage.DATA_TYPE__OWNED_ATTRIBUTE, DataType.class,
						msgs);
			case UMLPackage.PROPERTY__OWNING_ASSOCIATION :
				return eInternalContainer().eInverseRemove(this,
					UMLPackage.ASSOCIATION__OWNED_END, Association.class, msgs);
			case UMLPackage.PROPERTY__ASSOCIATION_END :
				return eInternalContainer().eInverseRemove(this,
					UMLPackage.PROPERTY__QUALIFIER, Property.class, msgs);
		}
		return eDynamicBasicRemoveFromContainer(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLPackage.PROPERTY__EANNOTATIONS :
				return getEAnnotations();
			case UMLPackage.PROPERTY__OWNED_ELEMENT :
				return getOwnedElements();
			case UMLPackage.PROPERTY__OWNER :
				if (resolve)
					return getOwner();
				return basicGetOwner();
			case UMLPackage.PROPERTY__OWNED_COMMENT :
				return getOwnedComments();
			case UMLPackage.PROPERTY__NAME :
				return getName();
			case UMLPackage.PROPERTY__VISIBILITY :
				return getVisibility();
			case UMLPackage.PROPERTY__QUALIFIED_NAME :
				return getQualifiedName();
			case UMLPackage.PROPERTY__CLIENT_DEPENDENCY :
				return getClientDependencies();
			case UMLPackage.PROPERTY__NAMESPACE :
				if (resolve)
					return getNamespace();
				return basicGetNamespace();
			case UMLPackage.PROPERTY__NAME_EXPRESSION :
				if (resolve)
					return getNameExpression();
				return basicGetNameExpression();
			case UMLPackage.PROPERTY__IS_LEAF :
				return isLeaf()
					? Boolean.TRUE
					: Boolean.FALSE;
			case UMLPackage.PROPERTY__REDEFINED_ELEMENT :
				return getRedefinedElements();
			case UMLPackage.PROPERTY__REDEFINITION_CONTEXT :
				return getRedefinitionContexts();
			case UMLPackage.PROPERTY__IS_STATIC :
				return isStatic()
					? Boolean.TRUE
					: Boolean.FALSE;
			case UMLPackage.PROPERTY__FEATURING_CLASSIFIER :
				return getFeaturingClassifiers();
			case UMLPackage.PROPERTY__TYPE :
				if (resolve)
					return getType();
				return basicGetType();
			case UMLPackage.PROPERTY__IS_ORDERED :
				return isOrdered()
					? Boolean.TRUE
					: Boolean.FALSE;
			case UMLPackage.PROPERTY__IS_UNIQUE :
				return isUnique()
					? Boolean.TRUE
					: Boolean.FALSE;
			case UMLPackage.PROPERTY__UPPER :
				return new Integer(getUpper());
			case UMLPackage.PROPERTY__LOWER :
				return new Integer(getLower());
			case UMLPackage.PROPERTY__UPPER_VALUE :
				if (resolve)
					return getUpperValue();
				return basicGetUpperValue();
			case UMLPackage.PROPERTY__LOWER_VALUE :
				if (resolve)
					return getLowerValue();
				return basicGetLowerValue();
			case UMLPackage.PROPERTY__IS_READ_ONLY :
				return isReadOnly()
					? Boolean.TRUE
					: Boolean.FALSE;
			case UMLPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER :
				if (resolve)
					return getOwningTemplateParameter();
				return basicGetOwningTemplateParameter();
			case UMLPackage.PROPERTY__TEMPLATE_PARAMETER :
				if (resolve)
					return getTemplateParameter();
				return basicGetTemplateParameter();
			case UMLPackage.PROPERTY__END :
				return getEnds();
			case UMLPackage.PROPERTY__DEPLOYMENT :
				return getDeployments();
			case UMLPackage.PROPERTY__DEPLOYED_ELEMENT :
				return getDeployedElements();
			case UMLPackage.PROPERTY__TEMPLATE_BINDING :
				return getTemplateBindings();
			case UMLPackage.PROPERTY__OWNED_TEMPLATE_SIGNATURE :
				if (resolve)
					return getOwnedTemplateSignature();
				return basicGetOwnedTemplateSignature();
			case UMLPackage.PROPERTY__CLASS_ :
				return getClass_();
			case UMLPackage.PROPERTY__DATATYPE :
				return getDatatype();
			case UMLPackage.PROPERTY__IS_DERIVED :
				return isDerived()
					? Boolean.TRUE
					: Boolean.FALSE;
			case UMLPackage.PROPERTY__IS_DERIVED_UNION :
				return isDerivedUnion()
					? Boolean.TRUE
					: Boolean.FALSE;
			case UMLPackage.PROPERTY__DEFAULT :
				return getDefault();
			case UMLPackage.PROPERTY__AGGREGATION :
				return getAggregation();
			case UMLPackage.PROPERTY__IS_COMPOSITE :
				return isComposite()
					? Boolean.TRUE
					: Boolean.FALSE;
			case UMLPackage.PROPERTY__REDEFINED_PROPERTY :
				return getRedefinedProperties();
			case UMLPackage.PROPERTY__OWNING_ASSOCIATION :
				if (resolve)
					return getOwningAssociation();
				return basicGetOwningAssociation();
			case UMLPackage.PROPERTY__DEFAULT_VALUE :
				if (resolve)
					return getDefaultValue();
				return basicGetDefaultValue();
			case UMLPackage.PROPERTY__OPPOSITE :
				if (resolve)
					return getOpposite();
				return basicGetOpposite();
			case UMLPackage.PROPERTY__SUBSETTED_PROPERTY :
				return getSubsettedProperties();
			case UMLPackage.PROPERTY__ASSOCIATION :
				if (resolve)
					return getAssociation();
				return basicGetAssociation();
			case UMLPackage.PROPERTY__QUALIFIER :
				return getQualifiers();
			case UMLPackage.PROPERTY__ASSOCIATION_END :
				return getAssociationEnd();
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
			case UMLPackage.PROPERTY__EANNOTATIONS :
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection) newValue);
				return;
			case UMLPackage.PROPERTY__OWNED_COMMENT :
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection) newValue);
				return;
			case UMLPackage.PROPERTY__NAME :
				setName((String) newValue);
				return;
			case UMLPackage.PROPERTY__VISIBILITY :
				setVisibility((VisibilityKind) newValue);
				return;
			case UMLPackage.PROPERTY__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection) newValue);
				return;
			case UMLPackage.PROPERTY__NAME_EXPRESSION :
				setNameExpression((StringExpression) newValue);
				return;
			case UMLPackage.PROPERTY__IS_LEAF :
				setIsLeaf(((Boolean) newValue).booleanValue());
				return;
			case UMLPackage.PROPERTY__IS_STATIC :
				setIsStatic(((Boolean) newValue).booleanValue());
				return;
			case UMLPackage.PROPERTY__TYPE :
				setType((Type) newValue);
				return;
			case UMLPackage.PROPERTY__IS_ORDERED :
				setIsOrdered(((Boolean) newValue).booleanValue());
				return;
			case UMLPackage.PROPERTY__IS_UNIQUE :
				setIsUnique(((Boolean) newValue).booleanValue());
				return;
			case UMLPackage.PROPERTY__UPPER :
				setUpper(((Integer) newValue).intValue());
				return;
			case UMLPackage.PROPERTY__LOWER :
				setLower(((Integer) newValue).intValue());
				return;
			case UMLPackage.PROPERTY__UPPER_VALUE :
				setUpperValue((ValueSpecification) newValue);
				return;
			case UMLPackage.PROPERTY__LOWER_VALUE :
				setLowerValue((ValueSpecification) newValue);
				return;
			case UMLPackage.PROPERTY__IS_READ_ONLY :
				setIsReadOnly(((Boolean) newValue).booleanValue());
				return;
			case UMLPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER :
				setOwningTemplateParameter((TemplateParameter) newValue);
				return;
			case UMLPackage.PROPERTY__TEMPLATE_PARAMETER :
				setTemplateParameter((TemplateParameter) newValue);
				return;
			case UMLPackage.PROPERTY__END :
				getEnds().clear();
				getEnds().addAll((Collection) newValue);
				return;
			case UMLPackage.PROPERTY__DEPLOYMENT :
				getDeployments().clear();
				getDeployments().addAll((Collection) newValue);
				return;
			case UMLPackage.PROPERTY__TEMPLATE_BINDING :
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection) newValue);
				return;
			case UMLPackage.PROPERTY__OWNED_TEMPLATE_SIGNATURE :
				setOwnedTemplateSignature((TemplateSignature) newValue);
				return;
			case UMLPackage.PROPERTY__DATATYPE :
				setDatatype((DataType) newValue);
				return;
			case UMLPackage.PROPERTY__IS_DERIVED :
				setIsDerived(((Boolean) newValue).booleanValue());
				return;
			case UMLPackage.PROPERTY__IS_DERIVED_UNION :
				setIsDerivedUnion(((Boolean) newValue).booleanValue());
				return;
			case UMLPackage.PROPERTY__DEFAULT :
				setDefault((String) newValue);
				return;
			case UMLPackage.PROPERTY__AGGREGATION :
				setAggregation((AggregationKind) newValue);
				return;
			case UMLPackage.PROPERTY__IS_COMPOSITE :
				setIsComposite(((Boolean) newValue).booleanValue());
				return;
			case UMLPackage.PROPERTY__REDEFINED_PROPERTY :
				getRedefinedProperties().clear();
				getRedefinedProperties().addAll((Collection) newValue);
				return;
			case UMLPackage.PROPERTY__OWNING_ASSOCIATION :
				setOwningAssociation((Association) newValue);
				return;
			case UMLPackage.PROPERTY__DEFAULT_VALUE :
				setDefaultValue((ValueSpecification) newValue);
				return;
			case UMLPackage.PROPERTY__OPPOSITE :
				setOpposite((Property) newValue);
				return;
			case UMLPackage.PROPERTY__SUBSETTED_PROPERTY :
				getSubsettedProperties().clear();
				getSubsettedProperties().addAll((Collection) newValue);
				return;
			case UMLPackage.PROPERTY__ASSOCIATION :
				setAssociation((Association) newValue);
				return;
			case UMLPackage.PROPERTY__QUALIFIER :
				getQualifiers().clear();
				getQualifiers().addAll((Collection) newValue);
				return;
			case UMLPackage.PROPERTY__ASSOCIATION_END :
				setAssociationEnd((Property) newValue);
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
			case UMLPackage.PROPERTY__EANNOTATIONS :
				getEAnnotations().clear();
				return;
			case UMLPackage.PROPERTY__OWNED_COMMENT :
				getOwnedComments().clear();
				return;
			case UMLPackage.PROPERTY__NAME :
				unsetName();
				return;
			case UMLPackage.PROPERTY__VISIBILITY :
				unsetVisibility();
				return;
			case UMLPackage.PROPERTY__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				return;
			case UMLPackage.PROPERTY__NAME_EXPRESSION :
				setNameExpression((StringExpression) null);
				return;
			case UMLPackage.PROPERTY__IS_LEAF :
				setIsLeaf(IS_LEAF_EDEFAULT);
				return;
			case UMLPackage.PROPERTY__IS_STATIC :
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case UMLPackage.PROPERTY__TYPE :
				setType((Type) null);
				return;
			case UMLPackage.PROPERTY__IS_ORDERED :
				setIsOrdered(IS_ORDERED_EDEFAULT);
				return;
			case UMLPackage.PROPERTY__IS_UNIQUE :
				setIsUnique(IS_UNIQUE_EDEFAULT);
				return;
			case UMLPackage.PROPERTY__UPPER :
				unsetUpper();
				return;
			case UMLPackage.PROPERTY__LOWER :
				unsetLower();
				return;
			case UMLPackage.PROPERTY__UPPER_VALUE :
				setUpperValue((ValueSpecification) null);
				return;
			case UMLPackage.PROPERTY__LOWER_VALUE :
				setLowerValue((ValueSpecification) null);
				return;
			case UMLPackage.PROPERTY__IS_READ_ONLY :
				setIsReadOnly(IS_READ_ONLY_EDEFAULT);
				return;
			case UMLPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER :
				setOwningTemplateParameter((TemplateParameter) null);
				return;
			case UMLPackage.PROPERTY__TEMPLATE_PARAMETER :
				setTemplateParameter((TemplateParameter) null);
				return;
			case UMLPackage.PROPERTY__END :
				getEnds().clear();
				return;
			case UMLPackage.PROPERTY__DEPLOYMENT :
				getDeployments().clear();
				return;
			case UMLPackage.PROPERTY__TEMPLATE_BINDING :
				getTemplateBindings().clear();
				return;
			case UMLPackage.PROPERTY__OWNED_TEMPLATE_SIGNATURE :
				setOwnedTemplateSignature((TemplateSignature) null);
				return;
			case UMLPackage.PROPERTY__DATATYPE :
				setDatatype((DataType) null);
				return;
			case UMLPackage.PROPERTY__IS_DERIVED :
				setIsDerived(IS_DERIVED_EDEFAULT);
				return;
			case UMLPackage.PROPERTY__IS_DERIVED_UNION :
				setIsDerivedUnion(IS_DERIVED_UNION_EDEFAULT);
				return;
			case UMLPackage.PROPERTY__DEFAULT :
				unsetDefault();
				return;
			case UMLPackage.PROPERTY__AGGREGATION :
				setAggregation(AGGREGATION_EDEFAULT);
				return;
			case UMLPackage.PROPERTY__IS_COMPOSITE :
				setIsComposite(IS_COMPOSITE_EDEFAULT);
				return;
			case UMLPackage.PROPERTY__REDEFINED_PROPERTY :
				getRedefinedProperties().clear();
				return;
			case UMLPackage.PROPERTY__OWNING_ASSOCIATION :
				setOwningAssociation((Association) null);
				return;
			case UMLPackage.PROPERTY__DEFAULT_VALUE :
				setDefaultValue((ValueSpecification) null);
				return;
			case UMLPackage.PROPERTY__OPPOSITE :
				setOpposite((Property) null);
				return;
			case UMLPackage.PROPERTY__SUBSETTED_PROPERTY :
				getSubsettedProperties().clear();
				return;
			case UMLPackage.PROPERTY__ASSOCIATION :
				setAssociation((Association) null);
				return;
			case UMLPackage.PROPERTY__QUALIFIER :
				getQualifiers().clear();
				return;
			case UMLPackage.PROPERTY__ASSOCIATION_END :
				setAssociationEnd((Property) null);
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
			case UMLPackage.PROPERTY__EANNOTATIONS :
				EList eAnnotations = (EList) eVirtualGet(UMLPackage.PROPERTY__EANNOTATIONS);
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UMLPackage.PROPERTY__OWNED_ELEMENT :
				return isSetOwnedElements();
			case UMLPackage.PROPERTY__OWNER :
				return isSetOwner();
			case UMLPackage.PROPERTY__OWNED_COMMENT :
				EList ownedComment = (EList) eVirtualGet(UMLPackage.PROPERTY__OWNED_COMMENT);
				return ownedComment != null && !ownedComment.isEmpty();
			case UMLPackage.PROPERTY__NAME :
				return isSetName();
			case UMLPackage.PROPERTY__VISIBILITY :
				return isSetVisibility();
			case UMLPackage.PROPERTY__QUALIFIED_NAME :
				return QUALIFIED_NAME_EDEFAULT == null
					? getQualifiedName() != null
					: !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UMLPackage.PROPERTY__CLIENT_DEPENDENCY :
				EList clientDependency = (EList) eVirtualGet(UMLPackage.PROPERTY__CLIENT_DEPENDENCY);
				return clientDependency != null && !clientDependency.isEmpty();
			case UMLPackage.PROPERTY__NAMESPACE :
				return isSetNamespace();
			case UMLPackage.PROPERTY__NAME_EXPRESSION :
				return eVirtualGet(UMLPackage.PROPERTY__NAME_EXPRESSION) != null;
			case UMLPackage.PROPERTY__IS_LEAF :
				return ((eFlags & IS_LEAF_EFLAG) != 0) != IS_LEAF_EDEFAULT;
			case UMLPackage.PROPERTY__REDEFINED_ELEMENT :
				return isSetRedefinedElements();
			case UMLPackage.PROPERTY__REDEFINITION_CONTEXT :
				return isSetRedefinitionContexts();
			case UMLPackage.PROPERTY__IS_STATIC :
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case UMLPackage.PROPERTY__FEATURING_CLASSIFIER :
				return isSetFeaturingClassifiers();
			case UMLPackage.PROPERTY__TYPE :
				return eVirtualGet(UMLPackage.PROPERTY__TYPE) != null;
			case UMLPackage.PROPERTY__IS_ORDERED :
				return ((eFlags & IS_ORDERED_EFLAG) != 0) != IS_ORDERED_EDEFAULT;
			case UMLPackage.PROPERTY__IS_UNIQUE :
				return ((eFlags & IS_UNIQUE_EFLAG) != 0) != IS_UNIQUE_EDEFAULT;
			case UMLPackage.PROPERTY__UPPER :
				return isSetUpper();
			case UMLPackage.PROPERTY__LOWER :
				return isSetLower();
			case UMLPackage.PROPERTY__UPPER_VALUE :
				return eVirtualGet(UMLPackage.PROPERTY__UPPER_VALUE) != null;
			case UMLPackage.PROPERTY__LOWER_VALUE :
				return eVirtualGet(UMLPackage.PROPERTY__LOWER_VALUE) != null;
			case UMLPackage.PROPERTY__IS_READ_ONLY :
				return isSetIsReadOnly();
			case UMLPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER :
				return basicGetOwningTemplateParameter() != null;
			case UMLPackage.PROPERTY__TEMPLATE_PARAMETER :
				return isSetTemplateParameter();
			case UMLPackage.PROPERTY__END :
				EList end = (EList) eVirtualGet(UMLPackage.PROPERTY__END);
				return end != null && !end.isEmpty();
			case UMLPackage.PROPERTY__DEPLOYMENT :
				EList deployment = (EList) eVirtualGet(UMLPackage.PROPERTY__DEPLOYMENT);
				return deployment != null && !deployment.isEmpty();
			case UMLPackage.PROPERTY__DEPLOYED_ELEMENT :
				return !getDeployedElements().isEmpty();
			case UMLPackage.PROPERTY__TEMPLATE_BINDING :
				EList templateBinding = (EList) eVirtualGet(UMLPackage.PROPERTY__TEMPLATE_BINDING);
				return templateBinding != null && !templateBinding.isEmpty();
			case UMLPackage.PROPERTY__OWNED_TEMPLATE_SIGNATURE :
				return eVirtualGet(UMLPackage.PROPERTY__OWNED_TEMPLATE_SIGNATURE) != null;
			case UMLPackage.PROPERTY__CLASS_ :
				return getClass_() != null;
			case UMLPackage.PROPERTY__DATATYPE :
				return getDatatype() != null;
			case UMLPackage.PROPERTY__IS_DERIVED :
				return ((eFlags & IS_DERIVED_EFLAG) != 0) != IS_DERIVED_EDEFAULT;
			case UMLPackage.PROPERTY__IS_DERIVED_UNION :
				return ((eFlags & IS_DERIVED_UNION_EFLAG) != 0) != IS_DERIVED_UNION_EDEFAULT;
			case UMLPackage.PROPERTY__DEFAULT :
				return isSetDefault();
			case UMLPackage.PROPERTY__AGGREGATION :
				return eVirtualGet(UMLPackage.PROPERTY__AGGREGATION,
					AGGREGATION_EDEFAULT) != AGGREGATION_EDEFAULT;
			case UMLPackage.PROPERTY__IS_COMPOSITE :
				return isComposite() != IS_COMPOSITE_EDEFAULT;
			case UMLPackage.PROPERTY__REDEFINED_PROPERTY :
				EList redefinedProperty = (EList) eVirtualGet(UMLPackage.PROPERTY__REDEFINED_PROPERTY);
				return redefinedProperty != null
					&& !redefinedProperty.isEmpty();
			case UMLPackage.PROPERTY__OWNING_ASSOCIATION :
				return basicGetOwningAssociation() != null;
			case UMLPackage.PROPERTY__DEFAULT_VALUE :
				return eVirtualGet(UMLPackage.PROPERTY__DEFAULT_VALUE) != null;
			case UMLPackage.PROPERTY__OPPOSITE :
				return basicGetOpposite() != null;
			case UMLPackage.PROPERTY__SUBSETTED_PROPERTY :
				EList subsettedProperty = (EList) eVirtualGet(UMLPackage.PROPERTY__SUBSETTED_PROPERTY);
				return subsettedProperty != null
					&& !subsettedProperty.isEmpty();
			case UMLPackage.PROPERTY__ASSOCIATION :
				return eVirtualGet(UMLPackage.PROPERTY__ASSOCIATION) != null;
			case UMLPackage.PROPERTY__QUALIFIER :
				EList qualifier = (EList) eVirtualGet(UMLPackage.PROPERTY__QUALIFIER);
				return qualifier != null && !qualifier.isEmpty();
			case UMLPackage.PROPERTY__ASSOCIATION_END :
				return getAssociationEnd() != null;
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == ParameterableElement.class) {
			switch (derivedFeatureID) {
				case UMLPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER :
					return UMLPackage.PARAMETERABLE_ELEMENT__OWNING_TEMPLATE_PARAMETER;
				case UMLPackage.PROPERTY__TEMPLATE_PARAMETER :
					return UMLPackage.PARAMETERABLE_ELEMENT__TEMPLATE_PARAMETER;
				default :
					return -1;
			}
		}
		if (baseClass == ConnectableElement.class) {
			switch (derivedFeatureID) {
				case UMLPackage.PROPERTY__END :
					return UMLPackage.CONNECTABLE_ELEMENT__END;
				default :
					return -1;
			}
		}
		if (baseClass == DeploymentTarget.class) {
			switch (derivedFeatureID) {
				case UMLPackage.PROPERTY__DEPLOYMENT :
					return UMLPackage.DEPLOYMENT_TARGET__DEPLOYMENT;
				case UMLPackage.PROPERTY__DEPLOYED_ELEMENT :
					return UMLPackage.DEPLOYMENT_TARGET__DEPLOYED_ELEMENT;
				default :
					return -1;
			}
		}
		if (baseClass == TemplateableElement.class) {
			switch (derivedFeatureID) {
				case UMLPackage.PROPERTY__TEMPLATE_BINDING :
					return UMLPackage.TEMPLATEABLE_ELEMENT__TEMPLATE_BINDING;
				case UMLPackage.PROPERTY__OWNED_TEMPLATE_SIGNATURE :
					return UMLPackage.TEMPLATEABLE_ELEMENT__OWNED_TEMPLATE_SIGNATURE;
				default :
					return -1;
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
		if (baseClass == ParameterableElement.class) {
			switch (baseFeatureID) {
				case UMLPackage.PARAMETERABLE_ELEMENT__OWNING_TEMPLATE_PARAMETER :
					return UMLPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER;
				case UMLPackage.PARAMETERABLE_ELEMENT__TEMPLATE_PARAMETER :
					return UMLPackage.PROPERTY__TEMPLATE_PARAMETER;
				default :
					return -1;
			}
		}
		if (baseClass == ConnectableElement.class) {
			switch (baseFeatureID) {
				case UMLPackage.CONNECTABLE_ELEMENT__END :
					return UMLPackage.PROPERTY__END;
				default :
					return -1;
			}
		}
		if (baseClass == DeploymentTarget.class) {
			switch (baseFeatureID) {
				case UMLPackage.DEPLOYMENT_TARGET__DEPLOYMENT :
					return UMLPackage.PROPERTY__DEPLOYMENT;
				case UMLPackage.DEPLOYMENT_TARGET__DEPLOYED_ELEMENT :
					return UMLPackage.PROPERTY__DEPLOYED_ELEMENT;
				default :
					return -1;
			}
		}
		if (baseClass == TemplateableElement.class) {
			switch (baseFeatureID) {
				case UMLPackage.TEMPLATEABLE_ELEMENT__TEMPLATE_BINDING :
					return UMLPackage.PROPERTY__TEMPLATE_BINDING;
				case UMLPackage.TEMPLATEABLE_ELEMENT__OWNED_TEMPLATE_SIGNATURE :
					return UMLPackage.PROPERTY__OWNED_TEMPLATE_SIGNATURE;
				default :
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected int eVirtualIndexBits(int offset) {
		switch (offset) {
			case 0 :
				return eVirtualIndexBits0;
			case 1 :
				return eVirtualIndexBits1;
			default :
				throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void eSetVirtualIndexBits(int offset, int newIndexBits) {
		switch (offset) {
			case 0 :
				eVirtualIndexBits0 = newIndexBits;
				break;
			case 1 :
				eVirtualIndexBits1 = newIndexBits;
				break;
			default :
				throw new IndexOutOfBoundsException();
		}
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
		result.append(" (isDerived: "); //$NON-NLS-1$
		result.append((eFlags & IS_DERIVED_EFLAG) != 0);
		result.append(", isDerivedUnion: "); //$NON-NLS-1$
		result.append((eFlags & IS_DERIVED_UNION_EFLAG) != 0);
		result.append(", aggregation: "); //$NON-NLS-1$
		result.append(eVirtualGet(UMLPackage.PROPERTY__AGGREGATION,
			AGGREGATION_EDEFAULT));
		result.append(", isReadOnly: "); //$NON-NLS-1$
		result.append((eFlags & IS_READ_ONLY_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetOwner() {
		TemplateParameter owningTemplateParameter = basicGetOwningTemplateParameter();
		if (owningTemplateParameter != null) {
			return owningTemplateParameter;
		}
		Property associationEnd = getAssociationEnd();
		if (associationEnd != null) {
			return associationEnd;
		}
		return super.basicGetOwner();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwner() {
		return super.isSetOwner()
			|| eIsSet(UMLPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER)
			|| eIsSet(UMLPackage.PROPERTY__ASSOCIATION_END);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedElements() {
		return super.isSetOwnedElements()
			|| eIsSet(UMLPackage.PROPERTY__DEPLOYMENT)
			|| eIsSet(UMLPackage.PROPERTY__TEMPLATE_BINDING)
			|| eIsSet(UMLPackage.PROPERTY__OWNED_TEMPLATE_SIGNATURE)
			|| eIsSet(UMLPackage.PROPERTY__DEFAULT_VALUE)
			|| eIsSet(UMLPackage.PROPERTY__QUALIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Namespace basicGetNamespace() {
		org.eclipse.uml2.uml.Class class_ = getClass_();
		if (class_ != null) {
			return class_;
		}
		DataType datatype = getDatatype();
		if (datatype != null) {
			return datatype;
		}
		Association owningAssociation = basicGetOwningAssociation();
		if (owningAssociation != null) {
			return owningAssociation;
		}
		return super.basicGetNamespace();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNamespace() {
		return super.isSetNamespace() || eIsSet(UMLPackage.PROPERTY__CLASS_)
			|| eIsSet(UMLPackage.PROPERTY__DATATYPE)
			|| eIsSet(UMLPackage.PROPERTY__OWNING_ASSOCIATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFeaturingClassifiers() {
		return super.isSetFeaturingClassifiers()
			|| eIsSet(UMLPackage.PROPERTY__CLASS_)
			|| eIsSet(UMLPackage.PROPERTY__DATATYPE)
			|| eIsSet(UMLPackage.PROPERTY__OWNING_ASSOCIATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRedefinedElements() {
		return super.isSetRedefinedElements()
			|| eIsSet(UMLPackage.PROPERTY__REDEFINED_PROPERTY);
	}

} //PropertyImpl
