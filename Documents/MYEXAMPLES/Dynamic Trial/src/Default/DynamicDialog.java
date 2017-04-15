package Default;


import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.ui.internal.EditorActionBuilder.ExternalContributor;


public class DynamicDialog extends Dialog {

   private Composite mPageDynamicComposite;
   private Composite businessDynamicComposite;
   private Composite externalDynamicComposite;
   private ScrolledComposite scrolledComposite;
   private Composite container;
   private Map<Button, Composite> disposeComp = new HashMap<Button,Composite>();
   private Map<Composite,Text> disposeNameText = new HashMap<Composite,Text>();
   private Button dynamicmPageBtnDel;
   private Button dynamicBusinessBtnDel ;
   private Button dynamicExternalBtnDel ;
   private  Composite composite;
   private Group grpMpageServers;
   private Group grpBusinessObjectServers;
   private Group grpExternalObjectServers;
   private Combo mPageServersCombo;
   private Combo businessObjServersCombo;
   private Combo externalServersCombo;
   /**
	 * Create the dialog.
	 * @param parentShell
	 */
	public DynamicDialog(Shell parentShell) {
		super(parentShell);
		
		
	}

	@Override
	protected void configureShell(Shell shell) {
	      super.configureShell(shell);
	      shell.setText("Manage External Servers");
	   }
	
	
	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea( Composite parent) {
		container = (Composite) super.createDialogArea(parent);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		
	    scrolledComposite = new ScrolledComposite(container, SWT.BORDER | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		scrolledComposite.setAlwaysShowScrollBars(true);
		composite = new Composite(scrolledComposite, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		createMpageServersGroup();	
		createBusinessObjectServersGroup();
		createExternalObjectServersGroup();
		
		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scrolledComposite.setContent(composite);
		scrolledComposite.setSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "SAVE",
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(600, 500);
	}
	
private void createMpageServersGroup(){
		
	    grpMpageServers = new Group(composite, SWT.NONE);
	    grpMpageServers.setLayout(new GridLayout(1, false));
		GridData gd_grpMpageServers = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		grpMpageServers.setLayoutData(gd_grpMpageServers);
		grpMpageServers.setText("mPage Servers");
		Composite topComposite = new Composite(grpMpageServers, SWT.NONE);
		topComposite.setLayout(new GridLayout(2, false));
		GridData gd_topComposite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_topComposite.widthHint = 421;
		gd_topComposite.heightHint = 58;
		topComposite.setLayoutData(gd_topComposite);
		
		Label lblDefault = new Label(topComposite, SWT.NONE);
		lblDefault.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDefault.setText("Default:");
		
		mPageServersCombo = new Combo(topComposite, SWT.NONE);
		mPageServersCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		final Composite middleComposite = new Composite(grpMpageServers, SWT.NONE);
		middleComposite.setLayout(new GridLayout(1, false));
		GridData gd_middleComposite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_middleComposite.widthHint = 426;
		middleComposite.setLayoutData(gd_middleComposite);
		
		final Composite staticComposite = new Composite(middleComposite, SWT.NONE);
		staticComposite .setLayout(new GridLayout(3, false));
		GridData gd_staticComposite= new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_staticComposite.widthHint = 426;
		staticComposite.setLayoutData(gd_staticComposite);
		Label nameLabel = new Label(staticComposite , SWT.NONE);
		nameLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1));
		nameLabel.setText("Name");
		Label addressLabel = new Label(staticComposite , SWT.NONE);
		addressLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1));
		addressLabel.setText("Base Address");
		Label emptyLabel = new Label(staticComposite , SWT.NONE);
		emptyLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1));

		final Text nameText = new Text(staticComposite , SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		 nameText.addFocusListener(new FocusListener(){

				@Override
				public void focusGained(FocusEvent e) {
				
					
				}

				@Override
				public void focusLost(FocusEvent e) {
					boolean dup = false;
					if(mPageServersCombo.getItemCount() != -1){
						for(int i=0;i<mPageServersCombo.getItems().length;i++)
						{
							if(nameText.getText().equalsIgnoreCase(mPageServersCombo.getItem(i)))
							{
								dup = true;
							}
						}
						if(dup == false){
						mPageServersCombo.add(nameText.getText());
					  }	    
					}
				}
			});
 
		
		final Text addressText = new Text(staticComposite , SWT.BORDER);
		addressText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		addressText.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				
				
			}	
		});
		Button static_btnDelete = new Button(staticComposite , SWT.NONE);
		static_btnDelete.setText("delete");
		static_btnDelete.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!nameText.getText().isEmpty() && !addressText.getText().isEmpty()){
				mPageServersCombo.remove(nameText.getText());
				nameText.setText("");
				addressText.setText("");
				
			}
		   }
		});
		Composite bottomComposite = new Composite(grpMpageServers, SWT.NONE);
		bottomComposite.setLayout(new GridLayout(1, false));
		GridData gd_bottomComposite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_bottomComposite.heightHint = 38;
		gd_bottomComposite.widthHint = 427;
		bottomComposite.setLayoutData(gd_bottomComposite);
		Button btnAdd = new Button(bottomComposite, SWT.NONE);
		btnAdd.setText("Add");
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                 
				mPageDynamicComposite = new Composite(middleComposite, SWT.NONE);
				mPageDynamicComposite.setLayout(new GridLayout(3, false));
				GridData gd_mPageDynamicComposite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
				gd_mPageDynamicComposite.widthHint = 426;
				mPageDynamicComposite.setLayoutData(gd_mPageDynamicComposite);
				
				Text dynamicmPageNameText = new Text(mPageDynamicComposite, SWT.BORDER);
				dynamicmPageNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
						false, 1, 1));
                 dynamicmPageNameText.addFocusListener(new MpageNameTextListeners());
				Text dynamicmPageAddressText = new Text(mPageDynamicComposite, SWT.BORDER);
				dynamicmPageAddressText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
						false, 1, 1));
				dynamicmPageAddressText.addFocusListener(new MpageAddressTextListeners());
				dynamicmPageBtnDel = new Button(mPageDynamicComposite, SWT.NONE);
				dynamicmPageBtnDel.setText("delete");
				dynamicmPageBtnDel.addSelectionListener(new DeleteAction());
				disposeComp.put(dynamicmPageBtnDel, mPageDynamicComposite);
				disposeNameText.put(mPageDynamicComposite,dynamicmPageNameText);
				scrolledComposite.layout(true, true);
	            scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
			}	
		});
	}
	
	
	private void createBusinessObjectServersGroup(){
		
		grpBusinessObjectServers = new Group(composite, SWT.NONE);
		grpBusinessObjectServers.setLayout(new GridLayout(1, false));
		GridData gd_grpBusinessObjectServers = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		grpBusinessObjectServers.setLayoutData(gd_grpBusinessObjectServers);
		grpBusinessObjectServers.setText("Business Object Servers");
		Composite topComposite = new Composite(grpBusinessObjectServers, SWT.NONE);
		topComposite.setLayout(new GridLayout(2, false));
		GridData gd_topComposite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_topComposite.widthHint = 421;
		gd_topComposite.heightHint = 58;
		topComposite.setLayoutData(gd_topComposite);
		
		Label lblDefault = new Label(topComposite, SWT.NONE);
		lblDefault.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDefault.setText("Default:");
		
		businessObjServersCombo = new Combo(topComposite, SWT.NONE);
		businessObjServersCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		final Composite middleComposite = new Composite(grpBusinessObjectServers, SWT.NONE);
		middleComposite.setLayout(new GridLayout(1, false));
		GridData gd_middleComposite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_middleComposite.widthHint = 426;
		middleComposite.setLayoutData(gd_middleComposite);
		
		final Composite staticComposite = new Composite(middleComposite, SWT.NONE);
		staticComposite.setLayout(new GridLayout(3, false));
		GridData gd_staticComposite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_staticComposite.widthHint = 426;
		staticComposite.setLayoutData(gd_staticComposite);
		
		Label nameLabel = new Label(staticComposite, SWT.NONE);
		nameLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1));
		nameLabel.setText("Name");
		Label addressLabel = new Label(staticComposite, SWT.NONE);
		addressLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1));
		addressLabel.setText("Base Address");
		Label emptyLabel = new Label(staticComposite, SWT.NONE);
		emptyLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1));
		

		final Text nameText = new Text(staticComposite, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
         nameText.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
			
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				boolean dup = false;
				if(businessObjServersCombo.getItemCount() != -1){
					for(int i=0;i<businessObjServersCombo.getItems().length;i++)
					{
						if(nameText.getText().equalsIgnoreCase(businessObjServersCombo.getItem(i)))
						{
							dup = true;
						}
					}
					if(dup == false){
						businessObjServersCombo.add(nameText.getText());
				  }	    
				}
			}
		});
		final Text addressText = new Text(staticComposite, SWT.BORDER);
		addressText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		addressText.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				
				
			}	
		});

		
		Button static_btnDelete = new Button(staticComposite, SWT.NONE);
		static_btnDelete.setText("delete");
		static_btnDelete.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!nameText.getText().isEmpty() && !addressText.getText().isEmpty()){
				businessObjServersCombo.remove(nameText.getText());
				nameText.setText("");
				addressText.setText("");
				
			}
		   }
		});
		
		Composite bottomCompsoite = new Composite(grpBusinessObjectServers, SWT.NONE);
		bottomCompsoite .setLayout(new GridLayout(1, false));
		GridData gd_bottomCompsoite  = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_bottomCompsoite .heightHint = 38;
		gd_bottomCompsoite .widthHint = 427;
		bottomCompsoite.setLayoutData(gd_bottomCompsoite );
		Button btnAdd = new Button(bottomCompsoite, SWT.NONE);
		btnAdd.setText("Add");
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                 
				businessDynamicComposite = new Composite(middleComposite, SWT.NONE);
				businessDynamicComposite.setLayout(new GridLayout(3, false));
				GridData gd_businessDynamicComposite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
				gd_businessDynamicComposite.widthHint = 426;
				businessDynamicComposite.setLayoutData(gd_businessDynamicComposite);
				
				Text dynamicBusinessNameText = new Text(businessDynamicComposite, SWT.BORDER);
				dynamicBusinessNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
						false, 1, 1));
                 dynamicBusinessNameText.addFocusListener(new BusinessNameTextListeners());
				Text dynamicBusinessAddressText = new Text(businessDynamicComposite, SWT.BORDER);
				dynamicBusinessAddressText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
						false, 1, 1));
                 dynamicBusinessAddressText.addFocusListener(new BusinessAddressTextListeners());
				dynamicBusinessBtnDel= new Button(businessDynamicComposite, SWT.NONE);
				dynamicBusinessBtnDel.setText("delete");
				dynamicBusinessBtnDel.addSelectionListener(new DeleteBusinessAction());
				disposeComp.put(dynamicBusinessBtnDel, businessDynamicComposite);
				disposeNameText.put(businessDynamicComposite, dynamicBusinessNameText);
				scrolledComposite.layout(true, true);
	            scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			}	
		});
	}
	
	
private void createExternalObjectServersGroup(){
		
	    grpExternalObjectServers = new Group(composite, SWT.NONE);
	    grpExternalObjectServers.setLayout(new GridLayout(1, false));
		GridData gd_grpExternalObjectServers = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		grpExternalObjectServers.setLayoutData(gd_grpExternalObjectServers);
		grpExternalObjectServers.setText("Other External Servers");
		Composite topComposite = new Composite(grpExternalObjectServers, SWT.NONE);
		topComposite.setLayout(new GridLayout(2, false));
		GridData gd_topComposite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_topComposite.widthHint = 421;
		gd_topComposite.heightHint = 58;
		topComposite .setLayoutData(gd_topComposite);
		
		Label lblDefault = new Label(topComposite , SWT.NONE);
		lblDefault.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDefault.setText("Default:");
		
	    externalServersCombo = new Combo(topComposite , SWT.DROP_DOWN | SWT.READ_ONLY);
		externalServersCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		
		
		final Composite middleComposite = new Composite(grpExternalObjectServers, SWT.NONE);
		middleComposite.setLayout(new GridLayout(1, false));
		GridData gd_middleComposite  = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_middleComposite.widthHint = 426;
		middleComposite.setLayoutData(gd_middleComposite);
		
		final Composite staticComposite = new Composite(middleComposite , SWT.NONE);
		staticComposite.setLayout(new GridLayout(3, false));
		GridData gd_staticComposite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_staticComposite.widthHint = 426;
		staticComposite.setLayoutData(gd_staticComposite);
		
		Label nameLabel = new Label(staticComposite, SWT.NONE);
		nameLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1));
		nameLabel.setText("Name");
		Label addressLabel = new Label(staticComposite, SWT.NONE);
		addressLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1));
		addressLabel.setText("Base Address");
		Label emptyLabel = new Label(staticComposite, SWT.NONE);
		emptyLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1));

		final Text nameText = new Text(staticComposite, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
        nameText.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				boolean dup = false;
				if(externalServersCombo.getItemCount() != -1){
					for(int i=0;i<externalServersCombo.getItems().length;i++)
					{
						if(nameText.getText().equalsIgnoreCase(externalServersCombo.getItem(i)))
						{
							dup = true;
						}
					}
					if(dup == false){
					externalServersCombo.add(nameText.getText());
				}	    
					
				
				}
			}
        });
		final Text addressText = new Text(staticComposite, SWT.BORDER);
		addressText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		
		
		addressText.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				
				
			}
			
			
			
			
			
		});
		Button static_btnDelete = new Button(staticComposite, SWT.NONE);
		static_btnDelete.setText("delete");
		static_btnDelete.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!nameText.getText().isEmpty() && !addressText.getText().isEmpty()){
				externalServersCombo.remove(nameText.getText());
				nameText.setText("");
				addressText.setText("");
				
			}
		   }
		});
		
		Composite bottomComposite = new Composite(grpExternalObjectServers, SWT.NONE);
		bottomComposite.setLayout(new GridLayout(1, false));
		GridData gd_composite_4 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite_4.heightHint = 38;
		gd_composite_4.widthHint = 427;
		bottomComposite.setLayoutData(gd_composite_4);
		Button btnAdd = new Button(bottomComposite, SWT.PUSH);
		btnAdd.setText("Add");
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                 
				externalDynamicComposite = new Composite(middleComposite , SWT.NONE);
				externalDynamicComposite.setLayout(new GridLayout(3, false));
				GridData gd_externalDynamicComposite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
				gd_externalDynamicComposite.widthHint = 426;
				externalDynamicComposite.setLayoutData(gd_externalDynamicComposite);
 
				Text dynamicNameText = new Text(externalDynamicComposite, SWT.BORDER);
				dynamicNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
						false, 1, 1));
				dynamicNameText.addFocusListener(new ExternalNameTextListeners()); 
				Text dynamicAddressText = new Text(externalDynamicComposite, SWT.BORDER);
				dynamicAddressText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
						false, 1, 1));
                 dynamicAddressText.addFocusListener(new ExternalAddressTextListeners());
				dynamicExternalBtnDel  = new Button(externalDynamicComposite, SWT.NONE);
				dynamicExternalBtnDel.setText("delete");
				dynamicExternalBtnDel.addSelectionListener(new DeleteExternalAction());
				disposeComp.put(dynamicExternalBtnDel, externalDynamicComposite);
				disposeNameText.put(externalDynamicComposite,dynamicNameText);
				scrolledComposite.layout(true, true);
	            scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			}	
		});
	}
	
	
	private class DeleteAction implements SelectionListener{

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			
			
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			
			        if(disposeComp.containsKey(e.getSource())){
			        if(!disposeNameText.get(disposeComp.get(e.getSource())).getText().isEmpty()){
			        mPageServersCombo.remove(disposeNameText.get(disposeComp.get(e.getSource())).getText());	
			        }
			        disposeComp.get(e.getSource()).dispose();
					scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
					composite.layout(true);
					composite.layout();
			        }	     
		   }
	   }
	
	private class DeleteBusinessAction implements SelectionListener{

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			
			
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			
			        if(disposeComp.containsKey(e.getSource())){
			        if(!disposeNameText.get(disposeComp.
			        		get(e.getSource())).getText().isEmpty())
			        {businessObjServersCombo.remove(disposeNameText.
			        		get(disposeComp.get(e.getSource())).getText());
			        }	
			        disposeComp.get(e.getSource()).dispose();
			        scrolledComposite.layout(true, true);
		            scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		            composite.layout(true);
					composite.layout();
			        }	    
		   }
	   }
	
	private class DeleteExternalAction implements SelectionListener{

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			
			
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			
			        if(disposeComp.containsKey(e.getSource())){
			        if(!disposeNameText.get(disposeComp.get(e.getSource())).getText().isEmpty()){	
			        externalServersCombo.remove(disposeNameText.
			        		get(disposeComp.get(e.getSource())).getText());
			        }
			        disposeComp.get(e.getSource()).dispose();
			        scrolledComposite.layout(true, true);
		            scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		            composite.layout(true);
					composite.layout();
			        }	  
			      }
		        }
	
	private class MpageNameTextListeners implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			Text nameText = (Text) e.getSource();
			boolean dup = false;
			if(mPageServersCombo.getItemCount() != -1){
				for(int i=0;i<mPageServersCombo.getItems().length;i++)
				{
					if(nameText.getText().equalsIgnoreCase(mPageServersCombo.getItem(i)))
					{
						dup = true;
					}
				}
				if(dup == false){
				mPageServersCombo.add(nameText.getText());
		  }
			
		}
	}
		
}
	private class MpageAddressTextListeners implements FocusListener
	{

		@Override
		public void focusGained(FocusEvent e) {
			
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			Text addressText = (Text) e.getSource();
			

		}

	}

	private class BusinessNameTextListeners implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			Text nameText = (Text) e.getSource();
			boolean dup = false;
			if(businessObjServersCombo.getItemCount() != -1){
				for(int i=0;i<businessObjServersCombo.getItems().length;i++)
				{
					if(nameText.getText().equalsIgnoreCase(businessObjServersCombo.getItem(i)))
					{
						dup = true;
					}
				}
				if(dup == false){
				businessObjServersCombo.add(nameText.getText());
		  }
			
		}
	}
		
}
	private class BusinessAddressTextListeners implements FocusListener
	{

		@Override
		public void focusGained(FocusEvent e) {
			
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			Text addressText = (Text) e.getSource();
			

		}

	}
	
	
	
	
private class ExternalNameTextListeners implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		Text nameText = (Text) e.getSource();
		boolean dup = false;
		if(externalServersCombo.getItemCount() != -1){
			for(int i=0;i<externalServersCombo.getItems().length;i++)
			{
				if(nameText.getText().equalsIgnoreCase(externalServersCombo.getItem(i)))
				{
					dup = true;
				}
			}
			if(dup == false){
			externalServersCombo.add(nameText.getText());
	  }
		
	}

  }
}
	private class ExternalAddressTextListeners implements FocusListener
	{

		@Override
		public void focusGained(FocusEvent e) {
			
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			Text addressText = (Text) e.getSource();
			

		}

	}
	
	
	

	
public static void main(String[] args){
	Display display = new Display();
	Shell shell =  new Shell(display);
	//shell.setLayout(new FillLayout());
	DynamicDialog dd = new DynamicDialog(shell);
	dd.open();
	while (!shell.isDisposed()) {
		if (!display.readAndDispatch())
		display.sleep();
		}
		display.dispose();
}


}


