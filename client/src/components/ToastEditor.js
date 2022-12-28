/* eslint-disable react/prop-types */
import { Editor } from '@toast-ui/react-editor';
import '@toast-ui/editor/dist/toastui-editor.css';
import { useRef } from 'react';


const ToastEditor = ({ onChangeHandler }) => {
  const editorRef = useRef();
  const handleContentChange = () => {
    const data = editorRef.current.getInstance().getMarkdown();
    onChangeHandler(data); //props로 받은 setContentvalue에 data 전달
  };


  return (
    <Editor
      ref={editorRef}
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
      onChange={handleContentChange}
    />
  );
};

export default ToastEditor;
