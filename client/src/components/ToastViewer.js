import { Viewer } from '@toast-ui/react-editor';
import '@toast-ui/editor/dist/toastui-editor-viewer.css';

const ToastViewer = ({ contents }) => {
  return <Viewer initialValue={contents || ''}></Viewer>;
};

export default ToastViewer;
