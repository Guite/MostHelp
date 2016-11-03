# Keyboard shortcuts

## Keyboard shortcuts in all editors

* **F1** - Open the help system.
* **Ctrl + E** - Display a filterable list of open editors to get direct access to an editor.
* **Ctrl + Shift + E** - Display the *Switch to Editor* dialog.
* **Ctrl + F6** - Display a list of open editors.  
* **Ctrl + PgUp / Ctrl + PgDown** - Navigate to previous / next editor tab.
* **Alt + ←** and **Alt + →** - Go to previous or next edit positions from the editor history list. On Mac use **Alt + Cmd** instead of **Alt** only.
* **Ctrl + A** - Select all.
* **Ctrl + Z** - Undo last action. On Mac use **Cmd + Z**.
* **Ctrl + Y** - Redo last action. On Linux use **Ctrl + Shift + Z**. On Mac use **Shift + Cmd + Z**.
* **Ctrl + S** - Save.
* **Ctrl + Shift + S** - Save all.
* **Ctrl + O** - Show quick outline. On Mac use **Cmd + O**.

## Keyboard shortcuts in diagram editors

### Navigation

* **Tab** - Cycle between shapes on the diagram from left to right.
* **Shift + Tab** - Cycle between shapes on the diagram from right to left.
* **Ctrl + Arrows** - Navigate between shapes on the diagram.
* **Alt + Down** - Navigate into a container.
* **Alt + Up** - Navigate out of a container.
* **/** - Navigate clockwise among the existing edges.
* **\** - Navigate counter-clockwise among the existing edges.

### Selection

* **Shift + Arrows** - Select in sequence. Hold down **Shift**, use navigation keys to select additional components.
* **Ctrl + Arrow + Space** - Select multiple. Hold down **Ctrl**, use navigation keys to navigate to additional components, press **Space** to select additional components.
* **Ctrl + Space** - Deselect the selected shape/edge by showing the shape/edge in an outline.
* **Esc** - Select diagram. Deselects all other previous selections.

### Editing

* **F2** - Direct edit of selected element.
* **F5** - Refresh. Force an update of the diagram according to the latest version of the semantic model.
* **Ctrl + C** - Copy semantic element into clipboard. On Mac use **Cmd + C**.
* **Ctrl + V** - Paste semantic element from clipboard. On Mac use **Cmd + V**.
* **Ctrl + Shift + Alt + C** - Copy layout.
* **Ctrl + Shift + Alt + V** - Paste layout.
* **Ctrl + H** - Hide element.
* **Ctrl + L** - Hide label. On Mac use **Cmd + L**.
* **Ctrl + Shift + L** - Show label. On Mac use **Cmd + Shift + L**.
* **Arrows** - Move shape.
* **.** - Cycle on element handles. Cycle on position handle / 8 side and corner size handles / position handle. Clockwise rotation.
* **.** - Cycle through edge points. Cycle through the end-points, bend-points, and mid-points of a connection. Clockwise rotation.
* **Ctrl + Shift + -** - Manage edge. Remove all the bend-points to retrieve an original straight edge. On Mac use **Cmd + Shift + -**.
* **. + Mouse** - Move a component. Cycle once to the move handle using the period key (**.**), use navigation keys to move, press **Enter** to accept new location or press **Escape** to cancel the move.
* **Shift + Mouse** - Constrain the move by snapping the shape to the grid.
* **Alt + Mouse** - Move without snap. This allows to ignore the snap while dragging a shape. On Mac use **Ctrl + Mouse**.
* **. + Resize** - Resize a component. Cycle to desired resize handle using the period key (**.**), use navigation keys to resize, press **Enter** to accept new size or press **Escape** to cancel the resize.
* **Ctrl + Resize** - Centered resize. Expands the shape on both opposite sides. On Mac use **Alt + Resize**.
* **Shift + Resize** - Resize that keeps the ratio.
* **Alt + Resize** - Resize without snap. Temporarily disables the snap during the resize if it is activated. On Mac use **Ctrl + Resize**.
* **F3 + Resize** - Resize container keeping children relative. When the shape is resized using the left and/or top border, the children (contained nodes for container and border nodes for all shapes) are moved with the border.
* **F4 + Resize** - Resize with snap to all shapes.
* **Ctrl + &** - Reset diagram. The diagram can have a negative origin or can be shifted toward the bottom-right with a blank zone at the top-left. This action aims to move all diagram elements to retrieve its origin while keeping the element layout. On Mac use **Cmd + &**.

### Diagram editor

* **Ctrl + =** - Zoom in.
* **Ctrl + -** - Zoom out.
* **Space + Mouse** - Pan when zoomed in. Hold down **Space** and drag the mouse.
* **Ctrl + Shift + Arrows** - Scroll in diagram.
* **Shift + F10** - Invokes the context menu for the shape.

### Palette

* **Space** or **Enter** - Collapse or expand the selected group.
* **Space** or **Enter** - Select tool.
* **Alt + Space** - Stack popup list appears.
* **Up** or **Down** - Navigate between group and tools.
* **Ctrl + Mouse** - Multiple additions. Select a palette tool for element creation and keep **Ctrl** pressed (**Alt** on Mac). Now you can use multiple mouse clicks for creating multiple elements without having to reselect the palette tool.

## Keyboard shortcuts in table and tree editors

* **F2** - Direct edit of selected element.
* **F5** - Refresh. Force an update of the displayed data according to the latest version of the semantic model.
* **+** - Expand direct children.
* **-** or **/** - Collapse.
* ** * ** - Expand all children.

## Keyboard shortcuts in textual editors

The following list shows some basic commands which might be helpful when using the textual editors.

* **Alt + Up** and **Alt + Down** - Move current line or selection one line up / down.
* **Alt + Left** and **Alt + Right** - Go back / forward in the history of editors.
* **Alt + Shift + Up** and **Alt + Shift + Down** - Expand selection to containing element.
* **Alt + Shift + R** - Rename current element as well as all other occurences.
* **F3 or Ctrl + MouseClick** - Follow reference under cursor.
* **Ctrl + Up** and **Ctrl + Down** - Scroll one line up / down.
* **Ctrl + 0** - Pop up outline for easy navigation and filtering.
* **Ctrl + 1** - Quick fix of errors.
* **Ctrl + Shift + C** - Single line comment/uncomment.
* **Ctrl + Shift + /** and **Ctrl + Shift + \** - Block comment/uncomment.
* **Ctrl + /** - Toggle comment for line or selection.
* **Ctrl + Space** - Start content assist suggesting possible values.
* **Ctrl + D** - Delete current line.
* **Ctrl + L** - Go to a certain line.
* **Ctrl + M** - Maximize current editor window.
* **Ctrl + W** - Close current editor tab.
* **Ctrl + Q** - Go to last edit location.
* **Ctrl + Shift + F** - Start the source code formatter.
* **Ctrl + Shift + G** - Find references to current element.
* **Ctrl + Shift + F3** - Locate a certain element.
* **Ctrl + ,** and **Ctrl + .** - Navigate between markers in the current editor.
* **Ctrl + J** - Incremental find. Note: Just press **Ctrl + J** and start typing the search text. Eclipse finds and highlights the next match as you type. Use **Up** or **Down** Arrow keys to jump to the next or previous match.
* **Ctrl + L** - Go to line from editor.
* **Ctrl + Q** - Go to last edit location.
* **Ctrl + Shift + P** - Navigate to matching bracket/brace.
* **Ctrl + X** - Cut selected text into clipboard. On Mac use **Cmd + X**.
* **Ctrl + C** - Copy selected text into clipboard. On Mac use **Cmd + C**.
* **Ctrl + V** - Paste text from clipboard. On Mac use **Cmd + V**.

