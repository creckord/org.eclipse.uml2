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
 * $Id: SequenceNodeItemProvider.java,v 1.2 2005/11/23 20:07:02 khussey Exp $
 */
package org.eclipse.uml2.uml.edit.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.uml2.uml.SequenceNode;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.uml2.uml.edit.UMLEditPlugin;

/**
 * This is the item provider adapter for a {@link org.eclipse.uml2.uml.SequenceNode} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SequenceNodeItemProvider
		extends StructuredActivityNodeItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceNodeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addExecutableNodePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Executable Node feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExecutableNodePropertyDescriptor(Object object) {
		itemPropertyDescriptors
			.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
					.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_SequenceNode_executableNode_feature"), //$NON-NLS-1$
				getString(
					"_UI_PropertyDescriptor_description", "_UI_SequenceNode_executableNode_feature", "_UI_SequenceNode_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE, true, null,
				null, new String[]{"org.eclipse.ui.views.properties.expert" //$NON-NLS-1$
				}));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures
				.add(UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE);
		}
		return childrenFeatures;
	}

	/**
	 * This returns SequenceNode.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return getResourceLocator().getImage("full/obj16/SequenceNode"); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((SequenceNode) object).getName();
		return label == null || label.length() == 0
			? getString("_UI_SequenceNode_type") : //$NON-NLS-1$
			getString("_UI_SequenceNode_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(SequenceNode.class)) {
			case UMLPackage.SEQUENCE_NODE__EXECUTABLE_NODE :
				fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds to the collection of {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing all of the children that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors,
			Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createStructuredActivityNode()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createCreateObjectAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createDestroyObjectAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createTestIdentityAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createReadSelfAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createReadStructuralFeatureAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createClearStructuralFeatureAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createRemoveStructuralFeatureValueAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createAddStructuralFeatureValueAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createReadLinkAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createCreateLinkAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createDestroyLinkAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createClearAssociationAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createBroadcastSignalAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createSendObjectAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createValueSpecificationAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createTimeObservationAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createDurationObservationAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createOpaqueAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createSendSignalAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createCallOperationAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createCallBehaviorAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createReadVariableAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createClearVariableAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createAddVariableValueAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createRemoveVariableValueAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createRaiseExceptionAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createReadExtentAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createReclassifyObjectAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createReadIsClassifiedObjectAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createStartClassifierBehaviorAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createReadLinkObjectEndAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createReadLinkObjectEndQualifierAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createCreateLinkObjectAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createAcceptEventAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createAcceptCallAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createReplyAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createUnmarshallAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createSequenceNode()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createConditionalNode()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createLoopNode()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE,
			UMLFactory.eINSTANCE.createExpansionRegion()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreateChildText(Object owner, Object feature,
			Object child, Collection selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == UMLPackage.Literals.ACTION__LOCAL_PRECONDITION
			|| childFeature == UMLPackage.Literals.ACTION__LOCAL_POSTCONDITION
			|| childFeature == UMLPackage.Literals.NAMESPACE__OWNED_RULE
			|| childFeature == UMLPackage.Literals.STRUCTURED_ACTIVITY_NODE__NODE
			|| childFeature == UMLPackage.Literals.SEQUENCE_NODE__EXECUTABLE_NODE;

		if (qualify) {
			return getString("_UI_CreateChild_text2", //$NON-NLS-1$
				new Object[]{getTypeText(childObject),
					getFeatureText(childFeature), getTypeText(owner)});
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return UMLEditPlugin.INSTANCE;
	}

}