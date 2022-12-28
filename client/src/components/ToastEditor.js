import { Editor } from '@toast-ui/react-editor';
import '@toast-ui/editor/dist/toastui-editor.css';
import { useRef } from 'react';

const ToastEditor = () => {
  const editorRef = useRef();

  const handleChange = () => {
    const content = editorRef.current.getInstance().getHTML();
    console.log(content);
  };

  return (
    <Editor
      initialValue=" "
      previewStyle="vertical"
      minheight="300px"
      height="auto"
      initialEditType="wysiwyg"
      useCommandShortcut={false}
      hideModeSwitch={true}
      toolbarItems={[
        ['heading', 'bold', 'italic', 'code'],
        ['link', 'quote', 'codeblock', 'image', 'table'],
        ['ol', 'ul', 'hr'],
      ]}
      onChange={handleChange}
      ref={editorRef}
    />
  );
};

export default ToastEditor;
