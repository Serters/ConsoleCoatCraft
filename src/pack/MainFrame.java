package pack;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.ListSelectionModel;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private static JLabel typeLabel;
	private static JList type;

	private static JLabel widthLabel;
	private static JTextField width;

	private static JLabel heightLabel;
	private static JTextField height;

	private static JLabel colorsLabel;
	private static JTextArea colors;

	private static JLabel imageLabel;
	private static JList image;

	private static JLabel fgColorLabel;
	private static JList fgColor;

	private static JLabel bgColorLabel;
	private static JList bgColor;

	private static JLabel sizeLabel;
	private static JTextField size;

	private static JButton create;

	private JLabel alignmentLabel;
	private static JList alignment;

	private static Flag flag;
	private JTextField horizontalAlignment;
	private JTextField verticalAlignment;

	public MainFrame(){
		setResizable(false);
		setSize(960, 360);
		setLocationRelativeTo(null);
		getContentPane().setForeground(new Color(255, 255, 255));
		setForeground(new Color(255, 255, 255));
		getContentPane().setFont(new Font("Lucida Console", Font.PLAIN, 12));
		setFont(new Font("Lucida Console", Font.PLAIN, 17));
		setTitle("Flag Builder");
		getContentPane().setBackground(new Color(63, 63, 63));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{
			120,
			120,
			120,
			0,
			0,
			0,
			0,
			0
		};
		gridBagLayout.rowHeights = new int[]{
			27,
			40,
			27,
			0,
			0,
			0
		};
		gridBagLayout.columnWeights = new double[]{
			0.0,
			0.0,
			0.0,
			1.0,
			1.0,
			1.0,
			0.0,
			Double.MIN_VALUE
		};
		gridBagLayout.rowWeights = new double[]{
			0.0,
			1.0,
			0.0,
			0.0,
			0.0,
			Double.MIN_VALUE
		};
		getContentPane().setLayout(gridBagLayout);

		typeLabel = new JLabel("Flag type");
		typeLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		typeLabel.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		typeLabel.setForeground(new Color(255, 255, 255));
		typeLabel.setBackground(new Color(106, 106, 106));
		GridBagConstraints gbc_typeLabel = new GridBagConstraints();
		gbc_typeLabel.fill = GridBagConstraints.BOTH;
		gbc_typeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_typeLabel.gridx = 0;
		gbc_typeLabel.gridy = 0;
		getContentPane().add(typeLabel, gbc_typeLabel);

		widthLabel = new JLabel("Width");
		widthLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		widthLabel.setBackground(new Color(106, 106, 106));
		widthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		widthLabel.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		widthLabel.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_widthLabel = new GridBagConstraints();
		gbc_widthLabel.fill = GridBagConstraints.BOTH;
		gbc_widthLabel.insets = new Insets(0, 0, 5, 5);
		gbc_widthLabel.gridx = 1;
		gbc_widthLabel.gridy = 0;
		getContentPane().add(widthLabel, gbc_widthLabel);
		widthLabel.setLabelFor(width);

		heightLabel = new JLabel("Height");
		heightLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		heightLabel.setBackground(new Color(106, 106, 106));
		heightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		heightLabel.setForeground(new Color(255, 255, 255));
		heightLabel.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		GridBagConstraints gbc_heightLabel = new GridBagConstraints();
		gbc_heightLabel.fill = GridBagConstraints.BOTH;
		gbc_heightLabel.insets = new Insets(0, 0, 5, 5);
		gbc_heightLabel.gridx = 2;
		gbc_heightLabel.gridy = 0;
		getContentPane().add(heightLabel, gbc_heightLabel);

		colorsLabel = new JLabel("Colors");
		colorsLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		colorsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		colorsLabel.setForeground(new Color(255, 255, 255));
		colorsLabel.setBackground(new Color(106, 106, 106));
		colorsLabel.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		GridBagConstraints gbc_colorsLabel = new GridBagConstraints();
		gbc_colorsLabel.gridwidth = 3;
		gbc_colorsLabel.fill = GridBagConstraints.BOTH;
		gbc_colorsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_colorsLabel.gridx = 3;
		gbc_colorsLabel.gridy = 0;
		getContentPane().add(colorsLabel, gbc_colorsLabel);

		type = new JList();
		type.setToolTipText("Flag Type");
		type.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				if(type.getSelectedIndex() > 1){
					imageLabel.setVisible(false);
					image.setVisible(false);

					fgColorLabel.setVisible(false);
					fgColor.setVisible(false);

					bgColorLabel.setVisible(false);
					bgColor.setVisible(false);

					sizeLabel.setVisible(false);
					size.setVisible(false);

					alignmentLabel.setVisible(false);
					alignment.setVisible(false);

					verticalAlignment.setVisible(false);
					horizontalAlignment.setVisible(false);
				}else{
					imageLabel.setVisible(true);
					image.setVisible(true);

					fgColorLabel.setVisible(true);
					fgColor.setVisible(true);

					bgColorLabel.setVisible(true);
					bgColor.setVisible(true);

					sizeLabel.setVisible(true);
					size.setVisible(true);

					alignmentLabel.setVisible(true);
					alignment.setVisible(true);

					verticalAlignment.setVisible(true);
					horizontalAlignment.setVisible(true);
				}
			}
		});
		type.setForeground(new Color(255, 255, 255));
		type.setBorder(new EmptyBorder(6, 6, 6, 6));
		type.setBackground(new Color(85, 85, 85));
		type.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		type.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		type.setVisibleRowCount(3);
		type.setModel(new AbstractListModel(){
			String[] values = new String[]{
				"Horizontal",
				"Vertical",
				"Plain Horizontal",
				"Plain Vertical"
			};
			public int getSize(){ return values.length; }

			public Object getElementAt(int index){
				return values[index];
			}
		});
		type.setSelectedIndex(0);
		GridBagConstraints gbc_type = new GridBagConstraints();
		gbc_type.fill = GridBagConstraints.BOTH;
		gbc_type.insets = new Insets(0, 0, 5, 5);
		gbc_type.gridx = 0;
		gbc_type.gridy = 1;
		getContentPane().add(type, gbc_type);

		width = new JTextField();
		width.setHorizontalAlignment(SwingConstants.CENTER);
		width.setToolTipText("Flag Width");
		width.setForeground(new Color(255, 255, 255));
		width.setText("216");
		width.setBackground(new Color(85, 85, 85));
		width.setFont(new Font("Lucida Console", Font.PLAIN, 17));
		GridBagConstraints gbc_width = new GridBagConstraints();
		gbc_width.fill = GridBagConstraints.BOTH;
		gbc_width.insets = new Insets(0, 0, 5, 5);
		gbc_width.gridx = 1;
		gbc_width.gridy = 1;
		getContentPane().add(width, gbc_width);
		width.setColumns(1);

		height = new JTextField();
		height.setHorizontalAlignment(SwingConstants.CENTER);
		height.setToolTipText("Flag Height");
		height.setText("144");
		height.setFont(new Font("Lucida Console", Font.PLAIN, 17));
		height.setForeground(new Color(255, 255, 255));
		height.setBackground(new Color(85, 85, 85));
		GridBagConstraints gbc_height = new GridBagConstraints();
		gbc_height.fill = GridBagConstraints.BOTH;
		gbc_height.insets = new Insets(0, 0, 5, 5);
		gbc_height.gridx = 2;
		gbc_height.gridy = 1;
		getContentPane().add(height, gbc_height);
		height.setColumns(1);

		create = new JButton("Create");
		create.setForeground(new Color(255, 255, 255));
		create.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				switch(type.getSelectedIndex()){
					case 0:
						try{
							flag = new HorizontalFlag(Integer.parseInt(width.getText()), Integer.parseInt(height.getText()), Integer.parseInt(size.getText()), (String) fgColor.getSelectedValue(), (String) bgColor.getSelectedValue(), (String) image.getSelectedValue(), Double.valueOf(verticalAlignment.getText()), Double.valueOf(horizontalAlignment.getText()), colors.getText().split(" "));
						}catch(NumberFormatException e1){
							e1.printStackTrace();
						}catch(IOException e1){
							e1.printStackTrace();
						}
					break;
					case 1:
						try{
							flag = new VerticalFlag(Integer.parseInt(width.getText()), Integer.parseInt(height.getText()), Integer.parseInt(size.getText()), (String) fgColor.getSelectedValue(), (String) bgColor.getSelectedValue(), (String) image.getSelectedValue(), Double.valueOf(verticalAlignment.getText()), Double.valueOf(horizontalAlignment.getText()), colors.getText().split(" "));
						}catch(NumberFormatException e1){
							e1.printStackTrace();
						}catch(IOException e1){
							e1.printStackTrace();
						}
					break;
					case 2:
						try{
							flag = new PlainHorizontalFlag(Integer.parseInt(width.getText()), Integer.parseInt(height.getText()), colors.getText().split(" "));
						}catch(NumberFormatException e1){
							e1.printStackTrace();
						}catch(IOException e1){
							e1.printStackTrace();
						}
					break;
					case 3:
						try{
							flag = new PlainVerticalFlag(Integer.parseInt(width.getText()), Integer.parseInt(height.getText()), colors.getText().split(" "));
						}catch(NumberFormatException e1){
							e1.printStackTrace();
						}catch(IOException e1){
							e1.printStackTrace();
						}
					break;
				}
				flag.print();

//				String[] command;
//				if(type.getSelectedIndex() < 2) command = new String[]{
//					"cmd.exe",
//					"/c",
//					"start",
//					"cmd.exe",
//					"/k",
//					"cd bin && cls && java pack.Main " +
//						type.getSelectedIndex() +
//						" " +
//						Integer.parseInt(width.getText()) +
//						" " +
//						Integer.parseInt(height.getText()) +
//						" " +
//						Integer.parseInt(size.getText()) +
//						" " +
//						fgColor.getSelectedValue() +
//						" " +
//						bgColor.getSelectedValue() +
//						" " +
//						image.getSelectedValue() +
//						" " +
//						Double.valueOf(verticalAlignment.getText()) +
//						" " +
//						Double.valueOf(horizontalAlignment.getText()) +
//						" " +
//						String.join(" ", colors.getText().split(" ")) +
//						" && exit"
//				};
//				else command = new String[]{
//					"cmd.exe",
//					"/c",
//					"start",
//					"cmd.exe",
//					"/k",
//					"cd bin && cls && java pack.Main " +
//						type.getSelectedIndex() +
//						" " +
//						Integer.parseInt(width.getText()) +
//						" " +
//						Integer.parseInt(height.getText()) +
//						" " +
//						String.join(" ", colors.getText().split(" ")) +
//						" && exit"
//				};
//				Runtime runtime = Runtime.getRuntime();
//				try{
//					Process p = runtime.exec(command);
//				}catch(IOException e1){
//					e1.printStackTrace();
//				}
			}
		});

		colors = new JTextArea();
		colors.setToolTipText("Flag Colors");
		colors.setForeground(new Color(255, 255, 255));
		colors.setLineWrap(true);
		colors.setWrapStyleWord(true);
		colors.setTabSize(4);
		colors.setText("red blue white");
		colors.setFont(new Font("Lucida Console", Font.PLAIN, 17));
		colors.setBackground(new Color(85, 85, 85));
		GridBagConstraints gbc_colors = new GridBagConstraints();
		gbc_colors.gridwidth = 3;
		gbc_colors.insets = new Insets(0, 0, 5, 5);
		gbc_colors.fill = GridBagConstraints.BOTH;
		gbc_colors.gridx = 3;
		gbc_colors.gridy = 1;
		getContentPane().add(colors, gbc_colors);
		colors.setColumns(10);
		create.setBackground(new Color(85, 85, 85));
		create.setFont(new Font("Lucida Console", Font.PLAIN, 17));
		GridBagConstraints gbc_create = new GridBagConstraints();
		gbc_create.gridheight = 5;
		gbc_create.fill = GridBagConstraints.BOTH;
		gbc_create.gridx = 6;
		gbc_create.gridy = 0;
		getContentPane().add(create, gbc_create);

		imageLabel = new JLabel("Coat of Arms");
		imageLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setForeground(new Color(255, 255, 255));
		imageLabel.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		imageLabel.setBackground(new Color(106, 106, 106));
		GridBagConstraints gbc_imageLabel = new GridBagConstraints();
		gbc_imageLabel.fill = GridBagConstraints.BOTH;
		gbc_imageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_imageLabel.gridx = 0;
		gbc_imageLabel.gridy = 2;
		getContentPane().add(imageLabel, gbc_imageLabel);

		fgColorLabel = new JLabel("Foreground color");
		fgColorLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		fgColorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fgColorLabel.setForeground(new Color(255, 255, 255));
		fgColorLabel.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		fgColorLabel.setBackground(new Color(106, 106, 106));
		GridBagConstraints gbc_fgColorLabel = new GridBagConstraints();
		gbc_fgColorLabel.fill = GridBagConstraints.BOTH;
		gbc_fgColorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fgColorLabel.gridx = 1;
		gbc_fgColorLabel.gridy = 2;
		getContentPane().add(fgColorLabel, gbc_fgColorLabel);

		bgColorLabel = new JLabel("Background color");
		bgColorLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		bgColorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bgColorLabel.setForeground(new Color(255, 255, 255));
		bgColorLabel.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		bgColorLabel.setBackground(new Color(106, 106, 106));
		GridBagConstraints gbc_bgColorLabel = new GridBagConstraints();
		gbc_bgColorLabel.fill = GridBagConstraints.BOTH;
		gbc_bgColorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_bgColorLabel.gridx = 2;
		gbc_bgColorLabel.gridy = 2;
		getContentPane().add(bgColorLabel, gbc_bgColorLabel);

		sizeLabel = new JLabel("Size");
		sizeLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		sizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sizeLabel.setForeground(new Color(255, 255, 255));
		sizeLabel.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		sizeLabel.setBackground(new Color(106, 106, 106));
		GridBagConstraints gbc_sizeLabel = new GridBagConstraints();
		gbc_sizeLabel.fill = GridBagConstraints.BOTH;
		gbc_sizeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_sizeLabel.gridx = 3;
		gbc_sizeLabel.gridy = 2;
		getContentPane().add(sizeLabel, gbc_sizeLabel);

		alignmentLabel = new JLabel("Alignment");
		alignmentLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		alignmentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		alignmentLabel.setForeground(new Color(255, 255, 255));
		alignmentLabel.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		alignmentLabel.setBackground(new Color(106, 106, 106));
		GridBagConstraints gbc_alignmentLabel = new GridBagConstraints();
		gbc_alignmentLabel.gridwidth = 2;
		gbc_alignmentLabel.fill = GridBagConstraints.BOTH;
		gbc_alignmentLabel.insets = new Insets(0, 0, 5, 5);
		gbc_alignmentLabel.gridx = 4;
		gbc_alignmentLabel.gridy = 2;
		getContentPane().add(alignmentLabel, gbc_alignmentLabel);

		image = new JList();
		image.setToolTipText("Coat of Arms Image");
		imageLabel.setLabelFor(image);
		image.setForeground(new Color(255, 255, 255));
		image.setVisibleRowCount(3);
		image.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		image.setModel(new AbstractListModel(){
			String[] values = new String[]{
				"circle",
				"crown",
				"dolphin",
				"eagle",
				"eagle_rgb",
				"fox",
				"goat",
				"horse",
				"print"
			};
			public int getSize(){ return values.length; }

			public Object getElementAt(int index){
				return values[index];
			}
		});
		image.setSelectedIndex(4);
		image.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		image.setBorder(new EmptyBorder(6, 6, 6, 6));
		image.setBackground(new Color(85, 85, 85));
		GridBagConstraints gbc_image = new GridBagConstraints();
		gbc_image.gridheight = 2;
		gbc_image.insets = new Insets(0, 0, 0, 5);
		gbc_image.fill = GridBagConstraints.BOTH;
		gbc_image.gridx = 0;
		gbc_image.gridy = 3;
		getContentPane().add(image, gbc_image);

		fgColor = new JList();
		fgColor.setToolTipText("Coat of Arms Foreground color");
		fgColorLabel.setLabelFor(fgColor);
		fgColor.setForeground(new Color(255, 255, 255));
		fgColor.setVisibleRowCount(3);
		fgColor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		fgColor.setModel(new AbstractListModel(){
			String[] values = new String[]{
				"white",
				"black",
				"red",
				"green",
				"blue",
				"yellow",
				"cyan",
				"purple",
				"none"
			};
			public int getSize(){ return values.length; }

			public Object getElementAt(int index){
				return values[index];
			}
		});
		fgColor.setSelectedIndex(5);
		fgColor.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		fgColor.setBorder(new EmptyBorder(6, 6, 6, 6));
		fgColor.setBackground(new Color(85, 85, 85));
		GridBagConstraints gbc_fgColor = new GridBagConstraints();
		gbc_fgColor.gridheight = 2;
		gbc_fgColor.insets = new Insets(0, 0, 0, 5);
		gbc_fgColor.fill = GridBagConstraints.BOTH;
		gbc_fgColor.gridx = 1;
		gbc_fgColor.gridy = 3;
		getContentPane().add(fgColor, gbc_fgColor);

		bgColor = new JList();
		bgColor.setToolTipText("Coat of Arms Background color");
		bgColorLabel.setLabelFor(bgColor);
		bgColor.setForeground(new Color(255, 255, 255));
		bgColor.setVisibleRowCount(3);
		bgColor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bgColor.setModel(new AbstractListModel(){
			String[] values = new String[]{
				"white",
				"black",
				"red",
				"green",
				"blue",
				"yellow",
				"cyan",
				"purple",
				"none"
			};
			public int getSize(){ return values.length; }

			public Object getElementAt(int index){
				return values[index];
			}
		});
		bgColor.setSelectedIndex(8);
		bgColor.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		bgColor.setBorder(new EmptyBorder(6, 6, 6, 6));
		bgColor.setBackground(new Color(85, 85, 85));
		GridBagConstraints gbc_bgColor = new GridBagConstraints();
		gbc_bgColor.gridheight = 2;
		gbc_bgColor.insets = new Insets(0, 0, 0, 5);
		gbc_bgColor.fill = GridBagConstraints.BOTH;
		gbc_bgColor.gridx = 2;
		gbc_bgColor.gridy = 3;
		getContentPane().add(bgColor, gbc_bgColor);

		size = new JTextField();
		size.setToolTipText("Coat of Arms Size");
		size.setHorizontalAlignment(SwingConstants.CENTER);
		sizeLabel.setLabelFor(size);
		size.setForeground(new Color(255, 255, 255));
		size.setText("108");
		size.setFont(new Font("Lucida Console", Font.PLAIN, 17));
		size.setColumns(1);
		size.setBackground(new Color(85, 85, 85));
		GridBagConstraints gbc_size = new GridBagConstraints();
		gbc_size.gridheight = 2;
		gbc_size.insets = new Insets(0, 0, 0, 5);
		gbc_size.fill = GridBagConstraints.BOTH;
		gbc_size.gridx = 3;
		gbc_size.gridy = 3;
		getContentPane().add(size, gbc_size);

		alignment = new JList();
		alignment.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				double index = (double) alignment.getSelectedIndex();
				verticalAlignment.setText("" + (index - index % 3) / 6);
				horizontalAlignment.setText("" + index % 3 * .5);
			}
		});
		alignment.setToolTipText("Coat of Arms Alignment");
		alignment.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		alignment.setVisibleRowCount(3);
		alignment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		alignment.setModel(new AbstractListModel(){
			String[] values = new String[]{
				"top left",
				"top center",
				"top right",
				"middle left",
				"middle center",
				"middle right",
				"bottom left",
				"bottom center",
				"bottom right"
			};
			public int getSize(){ return values.length; }

			public Object getElementAt(int index){
				return values[index];
			}
		});
		alignment.setSelectedIndex(4);
		alignment.setForeground(new Color(255, 255, 255));
		alignment.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		alignment.setBorder(new EmptyBorder(6, 6, 6, 6));
		alignment.setBackground(new Color(85, 85, 85));
		GridBagConstraints gbc_bgColor_1 = new GridBagConstraints();
		gbc_bgColor_1.gridwidth = 2;
		gbc_bgColor_1.insets = new Insets(0, 0, 5, 5);
		gbc_bgColor_1.fill = GridBagConstraints.BOTH;
		gbc_bgColor_1.gridx = 4;
		gbc_bgColor_1.gridy = 3;
		getContentPane().add(alignment, gbc_bgColor_1);

		verticalAlignment = new JTextField();
		verticalAlignment.setHorizontalAlignment(SwingConstants.CENTER);
		verticalAlignment.setToolTipText("Vertical Alignment");
		verticalAlignment.setText("0.385");
		verticalAlignment.setForeground(Color.WHITE);
		verticalAlignment.setFont(new Font("Lucida Console", Font.PLAIN, 17));
		verticalAlignment.setColumns(1);
		verticalAlignment.setBackground(new Color(85, 85, 85));
		GridBagConstraints gbc_verticalAlignment = new GridBagConstraints();
		gbc_verticalAlignment.insets = new Insets(0, 0, 0, 5);
		gbc_verticalAlignment.fill = GridBagConstraints.BOTH;
		gbc_verticalAlignment.gridx = 4;
		gbc_verticalAlignment.gridy = 4;
		getContentPane().add(verticalAlignment, gbc_verticalAlignment);

		horizontalAlignment = new JTextField();
		horizontalAlignment.setHorizontalAlignment(SwingConstants.CENTER);
		horizontalAlignment.setToolTipText("Horizontal Alignment");
		horizontalAlignment.setText("0.375");
		horizontalAlignment.setForeground(Color.WHITE);
		horizontalAlignment.setFont(new Font("Lucida Console", Font.PLAIN, 17));
		horizontalAlignment.setColumns(1);
		horizontalAlignment.setBackground(new Color(85, 85, 85));
		GridBagConstraints gbc_horizontalAlignment = new GridBagConstraints();
		gbc_horizontalAlignment.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalAlignment.fill = GridBagConstraints.BOTH;
		gbc_horizontalAlignment.gridx = 5;
		gbc_horizontalAlignment.gridy = 4;
		getContentPane().add(horizontalAlignment, gbc_horizontalAlignment);
		setBackground(new Color(106, 106, 106));
	}

	public static void main(String[] args) throws NumberFormatException, IOException{
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}
}
